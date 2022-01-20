package ma.ensa.springbatch.batch;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class BatchLauncher {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;


    public BatchStatus load() throws JobParametersInvalidException, JobExecutionAlreadyRunningException,
            JobRestartException, JobInstanceAlreadyCompleteException {

        Map<String, JobParameter> parametersMap = new HashMap<>();
        parametersMap.put("time",new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(parametersMap);
        JobExecution jobExecution = jobLauncher.run(job,jobParameters);
        while (jobExecution.isRunning()){
            System.out.println("Job is running ...");
        }
        return jobExecution.getStatus();

    }
}
