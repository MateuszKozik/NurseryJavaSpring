package com.kozik.nursery.controllers;

import com.kozik.nursery.entities.Fee;
import com.kozik.nursery.services.FeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FeeController {
    
    @Autowired private FeeService feeService;
    
    @GetMapping(value = "/fee/list")
    public String listAll(Model model){
        List<Fee> feeList = feeService.getAll();
        model.addAttribute("feeList", feeList);
        return "views/fee/list";
    }
    
    @GetMapping(value = "/fee/add")
    public String add(Model model){
        Fee fee = new Fee();
        model.addAttribute("fee", fee);
        return "views/fee/add";
    }
    
    @PostMapping(value = "/fee/add")
    public String add(@ModelAttribute("fee")Fee fee){
        feeService.save(fee);
        return "redirect:/fee/list";
    }
    
    @GetMapping(value = "/fee/edit/{id}")
    public String edit(@PathVariable("id")long id, Model model){
        Fee fee = feeService.get(id);
        model.addAttribute("fee", fee);
        return "views/fee/edit";
    }
    
    @PostMapping(value = "/fee/edit/{id}")
    public String edit(@PathVariable("id")long id,
            @ModelAttribute("fee")Fee fee){
        fee.setFeeID(id);
        feeService.save(fee);
        return "redirect:/fee/list";
    }
    
    @GetMapping(value = "/fee/delete/{id}")
    public String delete(@PathVariable("id")long id){
        feeService.delete(id);
        return "redirect:/fee/list";
    }
}
