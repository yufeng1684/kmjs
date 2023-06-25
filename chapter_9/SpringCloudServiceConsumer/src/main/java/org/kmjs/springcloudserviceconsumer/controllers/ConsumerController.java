package org.kmjs.springcloudserviceconsumer.controllers;

import org.kmjs.springcloudserviceconsumer.domian.DomainUser;
import org.kmjs.springcloudserviceconsumer.result.Result;
import org.kmjs.springcloudserviceconsumer.result.ResultCode;
import org.kmjs.springcloudserviceconsumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<String> addUser(@RequestBody @Validated DomainUser user) {
        Result<String> result = null;
        int ret = consumerService.saveUserToProvider(user);
        if (ret == 1) {
            result = new Result<>(ResultCode.OK);
        } else {
            result = new Result<>(ResultCode.Not_Found);
        }
        return result;
    }
}
