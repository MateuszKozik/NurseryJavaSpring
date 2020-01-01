package com.kozik.nursery.controllers;

import com.kozik.nursery.entities.Item;
import com.kozik.nursery.entities.Room;
import com.kozik.nursery.services.ItemService;
import com.kozik.nursery.services.RoomService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {
    
    @Autowired private ItemService itemService;
    @Autowired private RoomService roomService;
    
    @GetMapping(value = "/item/list")
    public String listAll(Model model){
        List<Item> itemList = itemService.getAll();
        model.addAttribute("itemList", itemList);
        return "views/item/list";
    }
    
    @GetMapping(value = "/item/add")
    public String add(Model model){
        List<Room> roomList = roomService.getAll();
        Item item = new Item();
        model.addAttribute("item", item);
        model.addAttribute("roomList", roomList);
        return "views/item/add";
    }
    
    @PostMapping(value = "/item/add")
    public String add(@ModelAttribute("item")Item item,
            @RequestParam("room")Room room){
        item.setRoom(room);
        itemService.save(item);
        return "redirect:/item/list";
    }
    
    @GetMapping(value = "/item/edit/{id}")
    public String edit(@PathVariable("id")long id, Model model){
        List<Room> roomList = roomService.getAll();
        Item item = itemService.get(id);
        model.addAttribute("item", item);
        model.addAttribute("roomList", roomList);
        return "views/item/edit";
    }
    
    @PostMapping(value = "/item/edit/{id}")
    public String edit(@PathVariable("id")long id,
            @ModelAttribute("item")Item item,
            @RequestParam("room")Room room){
        item.setInventoryNumber(id);
        item.setRoom(room);
        itemService.save(item);
        return "redirect:/item/list"; 
    }
    
    @GetMapping(value = "/item/delete/{id}")
    public String delete(@PathVariable("id")long id){
        itemService.delete(id);
        return "redirect:/item/list"; 
    }
}
