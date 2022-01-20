import ChainOfResponsibility.Service;
import ChainOfResponsibility.ServiceComptabilite;
import ChainOfResponsibility.ServiceGestionPatrimoine;
import Observer.Budget;
import Observer.Demande;

public class Main {
    public static void main(String[] args) {
        Budget budget = new Budget();
        Service serviceComptabilite = new ServiceComptabilite();
        Service serviceGestionPatrimoine = new ServiceGestionPatrimoine();
        serviceComptabilite.setNextHandler(serviceGestionPatrimoine);

        Demande d1 = new Demande();
        Demande d2 = new Demande();
        budget.setBudget(12489);
        demande1.setMontantGlobale(30007);
        demande2.setMontantGlobale(3000);
        budget.addObserver(d1);
        budget.addObserver(d2);
        budget.notifyDemande();
        serviceComptabilite.handleDemande(d1, budget);
        serviceComptabilite.handleDemande(d2, budget);
        budget.notifyDemande();


    }


}
