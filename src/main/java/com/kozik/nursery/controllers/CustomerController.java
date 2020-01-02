package com.kozik.nursery.controllers;

import com.kozik.nursery.entities.Address;
import com.kozik.nursery.entities.Parent;
import com.kozik.nursery.services.AddressService;
import com.kozik.nursery.services.ParentService;
import com.kozik.nursery.services.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @Autowired
    private UserService userService;
    @Autowired
    private ParentService parentService;
    @Autowired
    private AddressService addressService;

    @GetMapping("/customer/profile")
    public String edit(Model model, Principal principal) {
        String email = principal.getName();
        if (parentService.isParentPresent(email)) {
            Parent parent = parentService.getByEmail(email);
            model.addAttribute("parent", parent);
            if (parent.getAddress() == null) {
                Address address = new Address();
                model.addAttribute("address", address);
            } else {
                Address address = addressService.getByParent(parent.getParentID());
                model.addAttribute("address", address);
            }
            return "/views/customer/profile";
        } else {
            Parent parent = new Parent();
            Address address = new Address();
            model.addAttribute("parent", parent);
            model.addAttribute("address", address);
            return "views/customer/profile";
        }
    }

    @PostMapping("/customer/profile")
    public String edit(@ModelAttribute("parent") Parent parent,
            @ModelAttribute("address") Address address, Principal principal,
            Model model) {
        String email = principal.getName();
        parent.setUser(userService.get(email));
        addressService.save(address);
        parent.setAddress(address);
        parentService.save(parent);
        model.addAttribute("updated", true);
        return "views/customer/profile";
    }

}
