package org.kmjs.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.kmjs.spring.dao.ProductBeanMapper;
import org.kmjs.spring.domain.ProductBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis-base.xml", "classpath:spring-mybatis.xml"})
public class SpringTest {
    public static int recordId = 1;

    @Autowired
    private ProductBeanMapper productBeanMapper;

    @Test
    public void insert() {
        ProductBean record = new ProductBean();
        record.setId(recordId);
        record.setPrice(99);
        record.setProductName("kmjs map");
        record.setProductDesc("description");
        int affectNums = productBeanMapper.insert(record);
        System.out.println("insert affect row num is " + affectNums);
    }

    @Test
    public void selectByPrimaryKey() {
        System.out.println("selectByPrimaryKey id is " + recordId);
//        int id=2;
        ProductBean bean = productBeanMapper.selectByPrimaryKey(recordId);
        if(bean != null) {
            System.out.println(bean.getId() + " ");
            System.out.println(bean.getProductName() + " ");
            System.out.println(bean.getProductDesc() + " ");
            System.out.println(bean.getPrice() + " ");
        }
    }

    @Test
    public void updateByPrimaryKeySelective() {
        ProductBean record = new ProductBean();
        record.setId(recordId);
        record.setPrice(80);
        record.setProductName("kmjs map -update");
        int affectNums = productBeanMapper.updateByPrimaryKeySelective(record);
        System.out.println("updateByPrimaryKeySelective affect row num is " + affectNums);
    }

    @Test
    public void deleteByPrimaryKey() {
        int affectNums = productBeanMapper.deleteByPrimaryKey(recordId);
        System.out.println("deleteByPrimaryKey affect row num is " + affectNums);
    }
}
