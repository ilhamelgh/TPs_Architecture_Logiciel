package org.example;


import org.example.model.Category;
import org.example.model.Product;

public class App
{
    public static void main( String[] args ) throws Exception {
        Category category1 = new Category("category1");
        Category category2 = new Category("category2");
        Category category3 = new Category("category3");
        Product product = new Product("product");

        Category category4 = new Category("category4");
        Product product1 = new Product("product1");


        category1.addComponent(category1);
        category1.addComponent(category2);
        category1.addComponent(product);

        category1.addComponent(category3);
        category3.addComponent(product1);

        System.out.println("Tree from root category : ");
        category1.view();

        category2.deleteCategory();

        System.out.println("Tree from root category after delete: ");
        category1.view();
    }
}
