package com.kozik.nursery.controllers;

import com.kozik.nursery.services.RoomService;
import com.kozik.nursery.entities.Room;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoomController {
    
    @Autowired private RoomService roomService;
    
    @GetMapping(value = "/room/list")
    public String listAll(Model model){
        List<Room> roomList = roomService.getAll();
        model.addAttribute("roomList", roomList);
        return "views/room/list";
    }
    
    @GetMapping(value = "/room/add")
    public String add(Model model){
        Room room = new Room();
        model.addAttribute("room", room);
        return "views/room/add";
    }
    
    @PostMapping(value = "/room/add")
    public String add(@ModelAttribute("room")Room room){
        roomService.save(room);
        return "redirect:/room/list";
    }
    
    @GetMapping(value = "/room/edit/{id}")
    public String edit(@PathVariable("id")long id, Model model){
        Room room = roomService.get(id);
        model.addAttribute("room", room);
        return "views/room/edit";
    }
    
    @PostMapping(value = "/room/edit/{id}")
    public String edit(@PathVariable("id")long id,
            @ModelAttribute("room")Room room){
        room.setRoomID(id);
        roomService.save(room);
        return "redirect:/room/list";
    }
    
    @GetMapping(value = "/room/delete/{id}")
    public String delete(@PathVariable("id")long id){
        roomService.delete(id);
        return "redirect:/room/list";
    }
}
