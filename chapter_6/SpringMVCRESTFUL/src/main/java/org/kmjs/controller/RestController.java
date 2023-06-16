package org.kmjs.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.kmjs.domain.Product;
import org.kmjs.domain.ResultBean;
import org.kmjs.mybatis.dao.ProductBeanMapper;
import org.kmjs.mybatis.domain.ProductBean;

@Controller
@RequestMapping("/rest")
public class RestController {

    @Autowired
    ProductBeanMapper productBeanMapper;

    @RequestMapping(value = "/product/{proId}", method = RequestMethod.GET)
    public @ResponseBody ResultBean getProductInfo(@PathVariable("proId") Integer proId) {
        System.out.println("getProductInfo() called with: proId = [" + proId + "]");

        ProductBean productModel = productBeanMapper.selectByPrimaryKey(proId);
        if (null == productModel) {
            return ResultBean.ofFail(501, "未查询到此商品");
        }
        Product product = new Product();
        BeanUtils.copyProperties(productModel, product);
        return ResultBean.ofSuccess(product, "查询成功");
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public @ResponseBody ResultBean addProduct(@RequestBody Product product) {
        System.out.println("addProduct() called with: product = [" + product + "]");

        ProductBean productBean = new ProductBean();
        BeanUtils.copyProperties(product, productBean);
//        productBean.setId(product.getId());
//        productBean.setProductName(product.getProductName());
//        productBean.setPrice(product.getPrice());
//        productBean.setProductDesc(product.getProductDesc());
        productBeanMapper.insert(productBean);
        return ResultBean.ofSuccess(product, "添加成功");
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public @ResponseBody ResultBean updateProduct(@RequestBody Product product) {
        System.out.println("updateProduct() called with: product = [" + product + "]");

        if(product.getId() == 0) {
            return ResultBean.ofFail(502, "参数不正确");
        }

        ProductBean productBean = new ProductBean();
        BeanUtils.copyProperties(product, productBean);
//        productBean.setId(product.getId());
//        productBean.setProductName(product.getProductName());
//        productBean.setPrice(product.getPrice());
//        productBean.setProductDesc(product.getProductDesc());
        productBeanMapper.updateByPrimaryKeySelective(productBean);
        return ResultBean.ofSuccess(product, "更新成功");
    }

    @RequestMapping(value = "/product/{proId}", method = RequestMethod.DELETE)
    public @ResponseBody ResultBean delProduct(@PathVariable("proId") Integer proId) {
        System.out.println("delProduct() called with: proId = [" + proId + "]");

        int i = productBeanMapper.deleteByPrimaryKey(proId);
        if (i <= 0) {
            return ResultBean.ofFail(503, "删除失败");
        }
        return ResultBean.ofSuccess("删除成功");
    }
}
