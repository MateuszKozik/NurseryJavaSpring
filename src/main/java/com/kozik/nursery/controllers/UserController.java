package com.kozik.nursery.controllers;

import com.kozik.nursery.services.UserService;
import com.kozik.nursery.entities.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping(value = "/user/list")
    public String listAll(Model model) {
        List<User> userList = userService.getAll();
        model.addAttribute("userList", userList);
        return "views/user/list";
    }
    
    @GetMapping(value = "/user/add")
    public String add(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "views/user/add";
    }
    
    @PostMapping(value = "/user/add")
    public String add(@ModelAttribute("user") User user, Model model) {
        String password = user.getPassword();
        String retyped = user.getRetypedPassword();
        if (password.equals(retyped)) {
            userService.save(user);
            return "redirect:/user/list";
            
        } else {
            model.addAttribute("passwordFailed", true);
            return "views/user/add";            
        }        
    }
    
    @GetMapping(value = "/user/edit/{email}")
    public String edit(@PathVariable("email") String email, Model model) {
        User user = userService.get(email);
        model.addAttribute("user", user);
        return "views/user/edit";
    }
    
    @PostMapping(value = "/user/edit/{email}")
    public String edit(@PathVariable("email") String email,
            @ModelAttribute("user") User user, Model model) {
        String password = user.getPassword();
        String retyped = user.getRetypedPassword();
        if (password.equals(retyped)) {
            user.setEmail(email);
            userService.save(user);
            return "redirect:/user/list";       
        } else {
            model.addAttribute("passwordFailed", true);
            return "views/user/edit";            
        }        
    }
    
    @GetMapping(value = "/user/delete/{email}")
    public String delete(@PathVariable("email") String email) {
        userService.delete(email);
        return "redirect:/user/list";
    }
}
