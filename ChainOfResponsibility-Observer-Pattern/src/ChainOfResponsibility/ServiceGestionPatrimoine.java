package ChainOfResponsibility;

import Observer.Budget;
import Observer.Demande;

public class ServiceGestionPatrimoine implements Service {

    protected Service service;

    @Override
    public void setNext(Service service) {
        this.service = service;
    }

    @Override
    public void handleDemande(Demande demande, Budget budget) {
        budget.setBudget(budget.getBudget() - budget.getMontantBloque());
        budget.setMontantBloque(0);
        System.out.println(" budget : " + budget.getBudget() + "DH, montant bloqué : " + budget.getMontantBloque() + "DH");
    }
}
