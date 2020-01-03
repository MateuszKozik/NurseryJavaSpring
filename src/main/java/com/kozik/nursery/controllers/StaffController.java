package com.kozik.nursery.controllers;

import com.kozik.nursery.entities.Employee;
import com.kozik.nursery.entities.Address;
import com.kozik.nursery.entities.Group;
import com.kozik.nursery.entities.Parent;
import com.kozik.nursery.entities.Record;
import com.kozik.nursery.services.AddressService;
import com.kozik.nursery.services.EmployeeService;
import com.kozik.nursery.services.GroupService;
import com.kozik.nursery.services.RecordService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StaffController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private RecordService recordService;
    
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
        return "views/staff/list";
    }
    
    @GetMapping(value = "/staff/record")
    public String record(Model model){
        List<Record> recordList = recordService.getByGroupNull();
        List<Group> groupList = groupService.getAll();
        model.addAttribute("recordList", recordList);
        model.addAttribute(("groupList"), groupList);
        return "views/staff/record";
    }
    
    @PostMapping(value = "/staff/record/asign")
    public String asign(@RequestParam("group")long groupID,
            @RequestParam("record")long recordID){
        Group group = groupService.get(groupID);
        Record record = recordService.get(recordID);
        record.setGroup(group);
        recordService.save(record);
        return "redirect:/staff/record";
    }
}
