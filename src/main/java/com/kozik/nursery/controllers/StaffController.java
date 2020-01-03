package com.kozik.nursery.controllers;

import com.kozik.nursery.entities.Employee;
import com.kozik.nursery.entities.Address;
import com.kozik.nursery.entities.Group;
import com.kozik.nursery.entities.Parent;
import com.kozik.nursery.entities.Record;
import com.kozik.nursery.services.AddressService;
import com.kozik.nursery.services.EmployeeService;
import com.kozik.nursery.services.GroupService;
import com.kozik.nursery.services.UserService;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    private GroupService groupService;
    @Autowired
    private UserService userService;
    
    @GetMapping(value = "/staff/list")
    public String list(Model model, Principal principal){
        String email = principal.getName();
        Employee employee = employeeService.getByEmail(email);
        List<Group> groupList = groupService.getByEmployee(employee);
        Set<Record> recordList = new HashSet<Record>();
        for(Group group: groupList){
           recordList.addAll(group.getRecords());
        }
        model.addAttribute("recordList", recordList);
        return "/views/staff/list";
    }
}
