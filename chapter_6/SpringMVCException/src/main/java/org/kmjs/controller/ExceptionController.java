package org.kmjs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.kmjs.domain.Product;
import org.kmjs.domain.ResultBean;
import org.kmjs.exception.CustomException;

@Controller
@RequestMapping("/exception")
public class ExceptionController {
    @RequestMapping("/web")
    public String index() throws CustomException{
        if (1==1) {
            throw new CustomException("页面请求出现了异常");
        }
        return "demo";
    }

    @RequestMapping(value = "/json", method = RequestMethod.POST)
    public @ResponseBody ResultBean addProduct(@RequestBody Product product) throws CustomException{
        System.out.println("addProduct() called with:product = [" + product + "]");
        if (1==1) {
            throw new CustomException("Ajax请求出现了异常");
        }
        return ResultBean.ofSuccess();
    }
}
