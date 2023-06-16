package org.kmjs.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    @Qualifier("productDaoImpl")
    IProductDao productDao;
    public void addProduct(int id, String name) {
        System.out.println("invoke addProduct(int id, String name)");
        String result = productDao.addProduct(id, name);
        System.out.println(result);
    }
}
