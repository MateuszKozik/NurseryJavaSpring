package com.kozik.nursery.controllers;

import com.kozik.nursery.entities.Child;
import com.kozik.nursery.services.ChildService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChildController {
    
    @Autowired ChildService childService;
    
    @GetMapping(value = "/child/list")
    public String listAll(Model model){
        List<Child> childList = childService.getAll();
        model.addAttribute("childList", childList);
        return "views/child/list";
    }
    
    @GetMapping(value = "/child/add")
    public String add(Model model){
        Child child = new Child();
        model.addAttribute("child", child);
        return "views/child/add";
    }
    
    @PostMapping(value = "/child/add")
    public String add(@ModelAttribute("child")Child child){
        childService.save(child);
        return "redirect:/child/list";
    }
    
    @GetMapping(value = "/child/edit/{pesel}")
    public String edit(@PathVariable("pesel")String pesel, Model model){
        Child child = childService.get(pesel);
        model.addAttribute("child", child);
        return "views/child/edit";
    }
    
    @PostMapping(value = "/child/edit/{pesel}")
    public String edit(@PathVariable("pesel")String pesel,
            @ModelAttribute("child")Child child){
        child.setPesel(pesel);
        childService.save(child);
        return "redirect:/child/list";
    }
    
    @GetMapping(value = "/child/delete/{pesel}")
    public String delete(@PathVariable("pesel")String pesel){
        childService.delete(pesel);
        return "redirect:/child/list";
    }
}
