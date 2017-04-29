package com.oil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("msg", "Hello,this is index page");
        return "index";
    }
}