package org.kmjs.springbootjpa.controller;

import org.kmjs.springbootjpa.domain.User;
import org.kmjs.springbootjpa.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value="/page")
public class PageController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/save")
    public ModelAndView save(@ModelAttribute User user){
        userService.add(user);
        List<User> list = userService.getList();
        ModelAndView modelAndView = new ModelAndView("save");
        modelAndView.addObject("list", list);
        modelAndView.addObject("info", user.toString());
        return modelAndView;
    }
}
