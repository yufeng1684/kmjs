package org.kmjs.spring;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public String addProduct(int id, String name){
        System.out.println("invoke addProduct(int id, String name)");
        return "id is " + id + ", name is " + name;
    }

    public void doThrowException() {
        System.out.println("Exception raised");
        throw new IllegalArgumentException();
    }
}
