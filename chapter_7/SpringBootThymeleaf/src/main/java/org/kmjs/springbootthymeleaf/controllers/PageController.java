package org.kmjs.springbootthymeleaf.controllers;

import org.kmjs.springbootthymeleaf.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/page")
public class PageController {
    @RequestMapping(value="/welcome")
    public ModelAndView welcome() {
        return new ModelAndView("welcome");
    }

    @RequestMapping(value="/createuser")
    public ModelAndView createUser() {
        return new ModelAndView("createuser");
    }

    @RequestMapping(value="/save")
    public ModelAndView save(@ModelAttribute User user){
        ModelAndView modelAndView = new ModelAndView("save");
        modelAndView.addObject("info", user.toString());
        return modelAndView;
    }
}
