package org.kmjs.springbootparacheck.controller;

import org.kmjs.springbootparacheck.domain.User;
import org.kmjs.springbootparacheck.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value="/page")
public class PageController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/welcome")
    public ModelAndView welcome() {
        return new ModelAndView("welcome");
    }

    @RequestMapping(value="/createuser")
    public ModelAndView createUser() {
        ModelAndView modelAndView = new ModelAndView("createuser");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value="/save")
    public ModelAndView save(@Validated User user, BindingResult result, Model model){
        if (result != null && result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("createuser");
            modelAndView.addObject(model);
            return modelAndView;
        } else {
            userService.add(user);
            List<User> list = userService.getList();
            ModelAndView modelAndView = new ModelAndView("save");
            modelAndView.addObject("list", list);
            modelAndView.addObject("info", user.toString());
            return modelAndView;
        }
    }
}
