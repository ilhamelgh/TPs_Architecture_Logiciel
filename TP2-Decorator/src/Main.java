public class Main {
    public static void main(String[] args) {
        Assurance assurance = new AssuranceVoiture();
        assurance = new Incendie(assurance);
        assurance = new BrisDeGlace(assurance);
        assurance = new Inondation(assurance);
        System.out.println("Le frais totale est " + assurance.cost() + " DH");
    }
}
