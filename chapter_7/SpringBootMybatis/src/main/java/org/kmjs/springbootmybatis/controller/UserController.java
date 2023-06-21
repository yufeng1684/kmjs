package org.kmjs.springbootmybatis.controller;

import org.kmjs.springbootmybatis.domain.DomainUser;
import org.kmjs.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public DomainUser getUser(@PathVariable("Id") int id){
        return userService.getUser(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUser(@RequestBody DomainUser user){
        userService.saveUser(user);
    }
}
