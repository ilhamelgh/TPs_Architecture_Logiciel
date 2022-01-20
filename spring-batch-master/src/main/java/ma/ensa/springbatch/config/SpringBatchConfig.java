package ma.ensa.springbatch.config;

import ma.ensa.springbatch.batch.BatchLauncher;
import ma.ensa.springbatch.entities.Transaction;
import ma.ensa.springbatch.entities.TransactionContainer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableBatchProcessing
@EnableScheduling
public class SpringBatchConfig {


    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private ItemReader<TransactionContainer> transactionContainerItemReader;
    @Autowired
    private ItemProcessor<TransactionContainer, Transaction> transactionItemProcessor;
    @Autowired
    private ItemWriter<Transaction> transactionItemWriter;



    @Bean
    public FlatFileItemReader<TransactionContainer> fileItemReader(
            @Value("${inputFile}") Resource resource){
        FlatFileItemReader<TransactionContainer> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setName("Data-CSV-READER");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setResource(resource);
        flatFileItemReader.setLineMapper(lineMapper());
        return  flatFileItemReader;
    }

    @Bean
    public LineMapper<TransactionContainer> lineMapper() {
        DefaultLineMapper<TransactionContainer> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("idTransaction", "idCompte", "montant", "dateTransaction");
        lineMapper.setLineTokenizer(lineTokenizer);
        BeanWrapperFieldSetMapper<TransactionContainer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(TransactionContainer.class);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }



    @Bean
    public Job bankJob() {
        Step step1 = stepBuilderFactory.get("step-data-load")
                .<TransactionContainer, Transaction>chunk(10)
                .reader(transactionContainerItemReader)
                .processor(transactionItemProcessor)
                .writer(transactionItemWriter)
                .build();
        return jobBuilderFactory.get("data-loder-job")
                .start(step1)
                .build();
    }


    @Bean
    public BatchLauncher launchBatch(){
        return new BatchLauncher();
    }

    @Scheduled(cron = "0 00 05 1 * ?")
    public void scheduleFixedDelayTask() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        System.out.println(launchBatch().load());
    }

}
