package org.kmjs.springbootmybatis.controller;

import org.kmjs.springbootmybatis.domain.DomainUser;
import org.kmjs.springbootmybatis.result.Result;
import org.kmjs.springbootmybatis.result.ResultCode;
import org.kmjs.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public Result<DomainUser> getUser(@PathVariable("Id") int id){
        DomainUser domainUser =  userService.getUser(id);
        Result<DomainUser> result = null;
        if (domainUser != null) {
            result = new Result<>(ResultCode.OK,domainUser);
        } else {
            result = new Result<>(ResultCode.Not_Found);
        }
        return result;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result<String> addUser(@RequestBody @Validated DomainUser user){
        int ret = userService.saveUser(user);
        Result<String> result = null;
        if (ret == 1) {
            result = new Result<>(ResultCode.OK);
        } else {
            result = new Result<>(ResultCode.Not_Found);
        }
        return result;
    }
}
