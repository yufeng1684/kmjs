package org.kmjs.spring;

import org.springframework.stereotype.Repository;

//@Repository("productDaoImpl")
@Repository
public class ProductDaoImpl implements IProductDao {
    public String addProduct(int id, String name) {
        return "add product, id is " + id + ", name is " + name;
    }

}
