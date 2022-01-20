package org.example.model;

public abstract class Component {
    protected Category parentCategory;
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void view();
    protected abstract void view(int count);
}
