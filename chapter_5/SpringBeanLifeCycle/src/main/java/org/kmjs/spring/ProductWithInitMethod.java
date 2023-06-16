package org.kmjs.spring;

public class ProductWithInitMethod {
    private int id;
    private String name;

    public ProductWithInitMethod() {

    }

    public ProductWithInitMethod(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void initMethod() {
        System.out.println("invoke initMethod");
    }
}
