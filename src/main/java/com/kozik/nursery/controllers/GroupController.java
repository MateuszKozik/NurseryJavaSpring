package com.kozik.nursery.controllers;

import com.kozik.nursery.entities.Employee;
import com.kozik.nursery.services.GroupService;
import com.kozik.nursery.entities.Group;
import com.kozik.nursery.entities.Room;
import com.kozik.nursery.services.EmployeeService;
import com.kozik.nursery.services.RoomService;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

@Controller
public class GroupController {
 
    @Autowired private GroupService groupService;
    @Autowired private EmployeeService employeeService;
    @Autowired private RoomService roomService;
    
    @GetMapping(value = "/group/list")
    public String listAll(Model model){
        List<Group> groupList = groupService.getAll();
        model.addAttribute("groupList", groupList);
        return "views/group/list";
    }
    
    @GetMapping(value = "/group/add")
    public String add(Model model){
        List<Employee> employeeList = employeeService.getAll();
        List<Room> roomList = roomService.getAll();
        Group group = new Group();
        model.addAttribute("group", group);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("roomList", roomList);
        return "views/group/add";
    }
    
    @PostMapping(value = "/group/add")
    public String add(@ModelAttribute("group")Group group,
            @RequestParam("employees")HashSet<Employee> employees,
            @RequestParam("rooms")HashSet<Room> rooms){
        group.setEmployees(employees);
        group.setRooms(rooms);
        groupService.save(group);
        return "redirect:/group/list";
    }
    
    @GetMapping(value = "/group/edit/{id}")
    public String edit(@PathVariable("id")long id, Model model){
        List<Employee> employeeList = employeeService.getAll();
        List<Room> roomList = roomService.getAll();
        Group group = groupService.get(id);
        model.addAttribute("group", group);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("roomList", roomList);
        return "views/group/edit";
    }
    
    @PostMapping(value = "/group/edit/{id}")
    public String edit(@PathVariable("id")long id,
            @ModelAttribute("group")Group group,
            @RequestParam("employees")HashSet<Employee> employees,
            @RequestParam("rooms")HashSet<Room> rooms){
        group.setGroupID(id);
        group.setEmployees(employees);
        group.setRooms(rooms);
        groupService.save(group);
        return "redirect:/group/list";
    }
    
    @GetMapping(value = "/group/delete/{id}")
    public String delete(@PathVariable("id")long id){
        groupService.delete(id);
        return "redirect:/group/list";
    }
}
