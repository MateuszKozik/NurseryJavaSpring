package com.kozik.nursery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @GetMapping(value = "/")
    public String showHomePage(){
        return "/index";
    }
}
