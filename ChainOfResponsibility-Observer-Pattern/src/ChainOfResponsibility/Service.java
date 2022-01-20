package ChainOfResponsibility;

import Observer.Budget;
import Observer.Demande;

public interface Service {

     void setNext(Service service);

     void handleDemande(Demande demande, Budget budget);
}