package org.kmjs.springcloudserviceconsumer.controllers;

import org.kmjs.springcloudserviceconsumer.domian.DomainUser;
import org.kmjs.springcloudserviceconsumer.result.Result;
import org.kmjs.springcloudserviceconsumer.result.ResultCode;
import org.kmjs.springcloudserviceconsumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public Result<DomainUser> getUser(@PathVariable("Id") int id) {
        DomainUser user = consumerService.getUserFromProvider(id);
        Result<DomainUser> result = null;
        if (user != null) {
            result = new Result<>(ResultCode.OK, user);
        } else {
            result = new Result<>(ResultCode.Not_Found);
        }
        return result;
    }
}
