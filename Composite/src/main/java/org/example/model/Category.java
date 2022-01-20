package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Category extends Component {
    private List<Component> components = new ArrayList<>();

    public Category(String name) {
        super(name);
    }

    @Override
    public void view() {
        view(0);
    }

    @Override
    protected void view(int count) {
        System.out.println(this.name);
        count++;
        for (Component component : this.components) {
            for (int i = 0; i < count; i++) {
                System.out.print("\t");
            }
            component.view(count);
        }
    }

    public void addComponent(Component component) {
        component.parentCategory = this;
        this.components.add(component);
    }

    public void deleteComponent(Component component) {
        this.components.remove(component);
    }

    public void deleteCategory() throws Exception {
        if (this.parentCategory == null) {
            throw new Exception("impo de supprimer root cat ");
        }
        this.parentCategory.deleteComponent(this);
    }
}
