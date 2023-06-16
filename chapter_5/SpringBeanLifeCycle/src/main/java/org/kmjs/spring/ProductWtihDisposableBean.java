package org.kmjs.spring;

import org.springframework.beans.factory.DisposableBean;

public class ProductWtihDisposableBean implements DisposableBean {
//public class ProductWtihDisposableBean{
    private int id;
    private String name;

    public ProductWtihDisposableBean() {

    }

    public ProductWtihDisposableBean(int id , String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("invoke destroy()");
    }
}
