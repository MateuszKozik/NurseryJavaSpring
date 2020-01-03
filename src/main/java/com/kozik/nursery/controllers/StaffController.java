package com.kozik.nursery.controllers;

import com.kozik.nursery.entities.Employee;
import com.kozik.nursery.entities.Address;
import com.kozik.nursery.entities.Parent;
import com.kozik.nursery.services.AddressService;
import com.kozik.nursery.services.EmployeeService;
import com.kozik.nursery.services.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StaffController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;
    
    @GetMapping(value = "/staff/profile")
    public String profile(Model model, Principal principal){
        String email = principal.getName();
        if (employeeService.isEmployeePresent(email)) {
            Employee employee = employeeService.getByEmail(email);
            model.addAttribute("employee", employee);
            if (employee.getAddress() == null) {
                Address address = new Address();
                model.addAttribute("address", address);
            } else {
                Address address = addressService.getByEmployee(employee.getEmployeeID());
                model.addAttribute("address", address);
            }
                    return "views/staff/profile";
        } else {
            Employee employee = new Employee();
            Address address = new Address();
            model.addAttribute("employee", employee);
            model.addAttribute("address", address);
            return "views/staff/profile";
        }
    }
    
    @PostMapping("/staff/profile")
    public String edit(@ModelAttribute("employee") Employee employee,
            @ModelAttribute("address") Address address, Principal principal,
            Model model) {
        String email = principal.getName();
        employee.setUser(userService.get(email));
        addressService.save(address);
        employee.setAddress(address);
        employeeService.save(employee);
        model.addAttribute("updated", true);
        return "views/staff/profile";
    }
}
