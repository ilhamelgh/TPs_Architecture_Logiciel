package org.example.model;

public class Product extends Component {
    public Product(String name) {
        super(name);
    }

    @Override
    public void view() {
        System.out.println(this.name);
    }

    @Override
    protected void view(int count) {
        System.out.println(this.name);
    }
}
