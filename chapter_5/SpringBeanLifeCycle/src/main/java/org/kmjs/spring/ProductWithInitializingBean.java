package org.kmjs.spring;

import org.springframework.beans.factory.InitializingBean;

public class ProductWithInitializingBean implements InitializingBean{
    private int id;
    private String name;

    public ProductWithInitializingBean() {

    }

    public ProductWithInitializingBean(int id, String name){
        System.out.println("invoke method ProductWithInitializingBean(int id, String name)");
        this.id = id;
        this.name = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("execute afterPropertiesSet");
    }

    @Override
    public String toString() {
        return "id is " + id + ", name is " + name;
    }

}
