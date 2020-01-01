package com.kozik.nursery.controllers;

import com.kozik.nursery.entities.Address;
import com.kozik.nursery.entities.Employee;
import com.kozik.nursery.entities.User;
import com.kozik.nursery.entities.Room;
import com.kozik.nursery.services.EmployeeService;
import com.kozik.nursery.services.AddressService;
import com.kozik.nursery.services.RoomService;
import com.kozik.nursery.services.UserService;
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

@Controller
public class EmployeeController {
    
    @Autowired private EmployeeService employeeService;
    @Autowired private UserService userService;
    @Autowired private AddressService addressService;
    @Autowired private RoomService roomService;
    
    @GetMapping(value = "/employee/list")
    public String listAll(Model model){
        List<Employee> employeeList = employeeService.getAll();
        model.addAttribute("employeeList", employeeList);
        return "views/employee/list";
    }
    
    @GetMapping(value = "/employee/add")
    public String add(Model model){
        List<User> userList = userService.getAll();
        List<Address> addressList = addressService.getAll();
        List<Employee> employeeList = employeeService.getAll();
        List<Room> roomList = roomService.getAll();
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("userList", userList);
        model.addAttribute("addressList", addressList);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("roomList", roomList);
        return "views/employee/add";
    }
    
    @PostMapping(value = "/employee/add")
    public String add(@ModelAttribute("emloyee")Employee employee,
            @RequestParam(name = "user")User user,
            @RequestParam(name = "address")Address address,
            @RequestParam(name = "supervisor")Employee supervisor,
            @RequestParam(name = "rooms")HashSet<Room> rooms){
        employee.setRooms(rooms);
        employee.setSupervisor(supervisor);
        employee.setAddress(address);
        employee.setUser(user);
        employeeService.save(employee);
        return "redirect:/employee/list"; 
    }
    
    @GetMapping(value = "/employee/edit/{id}")
    public String edit(@PathVariable("id")long id, Model model){
        List<User> userList = userService.getAll();
        List<Address> addressList = addressService.getAll();
        List<Employee> employeeList = employeeService.getAll();
        List<Room> roomList = roomService.getAll();
        Employee employee = employeeService.get(id);
        model.addAttribute("employee", employee);
        model.addAttribute("userList", userList);
        model.addAttribute("addressList", addressList);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("roomList", roomList);
        return "views/employee/edit";
    }
    
    @PostMapping(value = "/employee/edit/{id}")
    public String edit(@PathVariable("id")long id,
            @ModelAttribute("employee")Employee employee,
            @RequestParam(name = "user")User user,
            @RequestParam(name = "address")Address address,
            @RequestParam(name = "supervisor")Employee supervisor,
            @RequestParam(name = "rooms")HashSet<Room> rooms){
        employee.setEmployeeID(id);
        employee.setSupervisor(supervisor);
        employee.setAddress(address);
        employee.setUser(user);
        employee.setRooms(rooms);
        employeeService.save(employee);
        return "redirect:/employee/list";
    }
    
    @GetMapping(value = "/employee/delete/{id}")
    public String delete(@PathVariable("id")long id){
        employeeService.delete(id);
        return "redirect:/employee/list";
    }
}
