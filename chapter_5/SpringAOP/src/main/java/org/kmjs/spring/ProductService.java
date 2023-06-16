package org.kmjs.spring;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
//    private int id;
//    private String name;

    public String addProduct(int id, String name){
        System.out.println("invoke addProduct(int id, String name)");
        return "id is " + id + ", name is " + name;
    }
}
