package com.kozik.nursery.controllers;

import com.kozik.nursery.entities.Role;
import com.kozik.nursery.entities.User;
import com.kozik.nursery.services.RoleService;
import com.kozik.nursery.services.UserService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "views/register";
    }

    @PostMapping(value = "/register")
    public String register(@Valid User user, Model model,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "views/register";
        }
        if (userService.isUserPresent(user.getEmail())) {
            model.addAttribute("exist", true);
            return "views/register";
        }
        Role role = roleService.getUser();
        Set<Role> roles = new HashSet<Role>();
        roles.add(role);
        userService.save(user, roles);
        model.addAttribute("success", true);
        return "views/register";
    }
}
