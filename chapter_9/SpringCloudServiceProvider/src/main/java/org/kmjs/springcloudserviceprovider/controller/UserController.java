package org.kmjs.springcloudserviceprovider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.kmjs.springcloudserviceprovider.domain.DomainUser;
import org.kmjs.springcloudserviceprovider.result.Result;
import org.kmjs.springcloudserviceprovider.result.ResultCode;
import org.kmjs.springcloudserviceprovider.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @HystrixCommand(commandKey = "provider-getuser", groupKey = "provider-usercontroller", fallbackMethod = "getUserFallBack")
    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public Result<DomainUser> getUser(@PathVariable("Id") int id){
        DomainUser domainUser =  userService.getUser(id);
        Result<DomainUser> result = null;
        if (domainUser != null) {
            result = new Result<>(ResultCode.OK,domainUser);
        } else {
            result = new Result<>(ResultCode.Not_Found);
        }
        log.info(result.toString());
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

    public Result<DomainUser> getUserFallBack(int id){
        Result<DomainUser> result = new Result<>(ResultCode.Unavailable);
        return result;
    }
}
