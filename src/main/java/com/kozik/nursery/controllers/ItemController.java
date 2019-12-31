package com.kozik.nursery.controllers;

import com.kozik.nursery.entities.Item;
import com.kozik.nursery.services.ItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {
    
    @Autowired private ItemService itemService;
    
    @GetMapping(value = "/item/list")
    public String listAll(Model model){
        List<Item> itemList = itemService.getAll();
        model.addAttribute("itemList", itemList);
        return "views/item/list";
    }
    
    @GetMapping(value = "/item/add")
    public String add(Model model){
        Item item = new Item();
        model.addAttribute("item", item);
        return "views/item/add";
    }
    
    @PostMapping(value = "/item/add")
    public String add(@ModelAttribute("item")Item item){
        itemService.save(item);
        return "redirect:/item/list";
    }
    
    @GetMapping(value = "/item/edit/{id}")
    public String edit(@PathVariable("id")long id, Model model){
        Item item = itemService.get(id);
        model.addAttribute("item", item);
        return "views/item/edit";
    }
    
    @PostMapping(value = "/item/edit/{id}")
    public String edit(@PathVariable("id")long id,
            @ModelAttribute("item")Item item){
        item.setInventoryNumber(id);
        itemService.save(item);
        return "redirect:/item/list"; 
    }
    
    @GetMapping(value = "/item/delete/{id}")
    public String delete(@PathVariable("id")long id){
        itemService.delete(id);
        return "redirect:/item/list"; 
    }
}
