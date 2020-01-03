package com.kozik.nursery.controllers;

import com.kozik.nursery.entities.Child;
import com.kozik.nursery.entities.Fee;
import com.kozik.nursery.entities.Parent;
import com.kozik.nursery.entities.Record;
import com.kozik.nursery.services.ChildService;
import com.kozik.nursery.services.FeeService;
import com.kozik.nursery.services.ParentService;
import com.kozik.nursery.services.RecordService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecordsController {

    @Autowired
    private ParentService parentService;
    @Autowired
    private ChildService childService;
    @Autowired
    private RecordService recordService;
    @Autowired
    private FeeService feeService;
    
    @GetMapping(value = "/customer/record")
    public String list(Model model, Principal principal) {
        String email = principal.getName();
        Parent parent = parentService.getByEmail(email);
        List<Child> childList = childService.getByParent(parent);
        List<Record> recordList = new ArrayList<Record>();
        for (Child child : childList) {
            Record record = recordService.getByChildAndDate(child);
            if (record != null) {
                recordList.add(record);
            }
        }
        Fee fee = feeService.getLast();
        model.addAttribute("recordList", recordList);
        model.addAttribute("childList", childList);
        model.addAttribute("fee", fee);
        return "views/customer/record";
    }

    @PostMapping(value = "/customer/record/add")
    public String add(@RequestParam("pesel") String pesel,
            @RequestParam("date") String date) {
        Child child = childService.get(pesel);
        child.setEnrolled(true);
        childService.save(child);
        recordService.saveByParent(child, date);
        return "redirect:/customer/record";
    }

    @GetMapping(value = "/customer/record/delete/{id}")
    public String delete(@PathVariable("id")long id) {
        Record record = recordService.get(id);
        Child child = record.getChild();
        child.setEnrolled(false);
        record.setGroup(null);
        recordService.save(record);
        childService.save(child);
        return "redirect:/customer/record";
    }
}
