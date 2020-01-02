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
    
    @GetMapping(value = "/customer/record")
    public String list(Model model, Principal principal){
        String email = principal.getName();
        Parent parent = parentService.getByEmail(email);
        List<Child> childList = childService.getByParent(parent);
        model.addAttribute("childList", childList);
        return "views/customer/record";
    }
    
    @PostMapping(value = "/customer/record/add")
    public String add(@RequestParam("pesel")String pesel,
            @RequestParam("date")String date){
        Child child = childService.get(pesel);
        child.setSaved(true);
        childService.save(child);
        recordService.saveByParent(child, date);
        return "redirect:/customer/record";
    }
    
    @GetMapping(value = "/customer/record/delete/{pesel}")
    public String delete(@PathVariable("pesel")String pesel){
        Child child = childService.get(pesel);
        child.setSaved(false);
        childService.save(child);
        Record record = recordService.getByChild(pesel);
        record.setGroup(null);
        recordService.save(record);
        return "redirect:/customer/record";
    }           
}
