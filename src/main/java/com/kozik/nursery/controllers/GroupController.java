package com.kozik.nursery.controllers;

import com.kozik.nursery.services.GroupService;
import com.kozik.nursery.entities.Group;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GroupController {
 
    @Autowired GroupService groupService;
    
    @GetMapping(value = "/group/list")
    public String listAll(Model model){
        List<Group> groupList = groupService.getAll();
        model.addAttribute("groupList", groupList);
        return "views/group/list";
    }
    
    @GetMapping(value = "/group/save")
    public String add(Model model){
        Group group = new Group();
        model.addAttribute("group", group);
        return "views/group/add";
    }
    
    @PostMapping(value = "/group/save")
    public String add(@ModelAttribute("group")Group group){
        groupService.save(group);
        return "redirect:/group/list";
    }
    
    @GetMapping(value = "/group/edit/{id}")
    public String edit(@PathVariable("id")long id, Model model){
        Group group = groupService.get(id);
        model.addAttribute("group", group);
        return "views/group/edit";
    }
    
    @PostMapping(value = "/group/edit/{id}")
    public String edit(@PathVariable("id")long id,
            @ModelAttribute("group")Group group){
        group.setGroupID(id);
        groupService.save(group);
        return "redirect:/group/list";
    }
    
    @GetMapping(value = "/group/delete/{id}")
    public String delete(@PathVariable("id")long id){
        groupService.delete(id);
        return "redirect:/group/list";
    }
}
