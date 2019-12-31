package com.kozik.nursery.controllers;

import com.kozik.nursery.entities.Parent;
import com.kozik.nursery.services.ParentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ParentController {
    
    @Autowired private ParentService parentService;
    
    @GetMapping(value = "/parent/list")
    public String listAll(Model model){
        List<Parent> parentList = parentService.getAll();
        model.addAttribute("parentList", parentList);
        return "views/parent/list";
    }
    
    @GetMapping(value = "/parent/add")
    public String add(Model model){
        Parent parent = new Parent();
        model.addAttribute("parent", parent);
        return "views/parent/add";
    }
    
    @PostMapping(value = "/parent/add")
    public String add(@ModelAttribute("parent")Parent parent){
        parentService.save(parent);
        return "redirect:/parent/list";
    }
    
    @GetMapping(value = "/parent/edit/{id}")
    public String edit(@PathVariable("id")long id, Model model){
        Parent parent = parentService.get(id);
        model.addAttribute("parent", parent);
        return "views/parent/edit";
    }
    
    @PostMapping(value = "/parent/edit/{id}")
    public String edit(@PathVariable("id")long id,
            @ModelAttribute("parent")Parent parent){
        parent.setParentID(id);
        parentService.save(parent);
        return "redirect:/parent/list";
    }
    
    @GetMapping(value = "/parent/delete/{id}")
    public String delete(@PathVariable("id")long id){
        parentService.delete(id);
        return "redirect:/parent/list";
    }
}