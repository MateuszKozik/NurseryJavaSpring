package com.kozik.nursery.controllers;

import com.kozik.nursery.entities.Address;
import com.kozik.nursery.services.AddressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddressController {
    
    @Autowired private AddressService addressService;
    
    @GetMapping(value = "/address/list")
    public String listAll(Model model){
        List<Address> listAddress = addressService.getAll();
        model.addAttribute("listAddress", listAddress);
        return "views/address/list";
    }
    
    @GetMapping(value = "/address/add")
    public String add(Model model){
        Address address = new Address();
        model.addAttribute("address", address);              
        return "views/address/add";
    }
    
    @PostMapping(value = "/address/add")
    public String add(@ModelAttribute("address")Address address){
        addressService.save(address);
        return "redirect:/address/list";
    }
    
    @GetMapping(value = "/address/edit/{id}")
    public String edit(@PathVariable(name="id")long id, Model model){
        Address address = addressService.get(id);
        model.addAttribute("address", address);
        return "views/adres/edit/";
    }
    
    @PostMapping(value = "/address/edit/{id}")
    public String edit(@PathVariable(name = "id")long id,
            @ModelAttribute("address") Address address){
        address.setAddressID(id);
        addressService.save(address);
        return "redirect:/address/list";
    }
    
    @GetMapping(value = "/address/delete/{id}")
    public String delete(@PathVariable(name = "id")long id){
        addressService.delete(id);
        return "redirect:/address/list";
    }
}