package com.kozik.nursery.controllers;

import com.kozik.nursery.entities.Fee;
import com.kozik.nursery.services.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping(value = "/")
    public String showHomePage(Model model){
        return "/index";
    }
}
