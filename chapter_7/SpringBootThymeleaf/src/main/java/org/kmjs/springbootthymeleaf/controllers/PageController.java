package org.kmjs.springbootthymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/page")
public class PageController {
    @RequestMapping(value="/welcome")
    public ModelAndView welcome() {
        return new ModelAndView("welcome");
    }
}
