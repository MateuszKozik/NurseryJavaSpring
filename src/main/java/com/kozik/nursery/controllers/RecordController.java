package com.kozik.nursery.controllers;

import com.kozik.nursery.entities.Fee;
import com.kozik.nursery.entities.Group;
import com.kozik.nursery.services.RecordService;
import com.kozik.nursery.entities.Record;
import com.kozik.nursery.services.FeeService;
import com.kozik.nursery.services.GroupService;
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
public class RecordController {
    
    @Autowired private RecordService recordService;
    @Autowired private FeeService feeService;
    @Autowired private GroupService groupService;
    
    @GetMapping(value = "/record/list")
    public String listAll(Model model){
        List<Record> recordList = recordService.getAll();
        model.addAttribute("recordList", recordList);
        return "views/record/list";
    }
    
    @GetMapping(value = "/record/add")
    public String add(Model model){
        List<Group> groupList = groupService.getAll();
        List<Fee> feeList = feeService.getAll();
        Record record = new Record();
        model.addAttribute("record", record);
        model.addAttribute("groupList", groupList);
        model.addAttribute("feeList", feeList);
        return "views/record/add";
    }
    
    @PostMapping(value = "/record/add")
    public String add(@ModelAttribute("record")Record record,
            @RequestParam("group")Group group,
            @RequestParam("fee")Fee fee){
        record.setGroup(group);
        record.setFee(fee);
        recordService.save(record);
        return "redirect:/record/list";
    }
    
    @GetMapping(value = "/record/edit/{id}")
    public String edit(@PathVariable("id")long id, Model model){
        List<Group> groupList = groupService.getAll();
        List<Fee> feeList = feeService.getAll();
        Record record = recordService.get(id);
        model.addAttribute("record", record);
        model.addAttribute("groupList", groupList);
        model.addAttribute("feeList", feeList);
        return "views/record/edit";
    }
    
    @PostMapping(value = "/record/edit/{id}")
    public String edit(@PathVariable("id")long id,
            @ModelAttribute("record")Record record,
            @RequestParam("group")Group group,
            @RequestParam("fee")Fee fee){
        record.setRecordID(id);
        record.setGroup(group);
        record.setFee(fee);
        recordService.save(record);
        return "redirect:/record/list";
    }
    
    @GetMapping(value = "/record/delete/{id}")
    public String delete(@PathVariable("id")long id){
        recordService.delete(id);
        return "redirect:/record/list";
    }
}
