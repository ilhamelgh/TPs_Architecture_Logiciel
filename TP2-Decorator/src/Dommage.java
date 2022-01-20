public class Dommage extends GammeDecorator {

    public Dommage(Assurance assurance){
        super(assurance);
    }
    @Override
    public int cost() {
        return this.assurance.cost()+1000;
    }
}
