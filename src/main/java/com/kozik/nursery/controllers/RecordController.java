package com.kozik.nursery.controllers;

import com.kozik.nursery.services.RecordService;
import com.kozik.nursery.entities.Record;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecordController {
    
    @Autowired private RecordService recordService;
    
    @GetMapping(value = "/record/list")
    public String listAll(Model model){
        List<Record> recordList = recordService.getAll();
        model.addAttribute("recordList", recordList);
        return "views/record/list";
    }
    
    @GetMapping(value = "/record/add")
    public String add(Model model){
        Record record = new Record();
        model.addAttribute("record", record);
        return "views/record/add";
    }
    
    @PostMapping(value = "/record/add")
    public String add(@ModelAttribute("record")Record record){
        recordService.save(record);
        return "redirect:/record/list";
    }
    
    @GetMapping(value = "/record/edit/{id}")
    public String edit(@PathVariable("id")long id, Model model){
        Record record = recordService.get(id);
        model.addAttribute("record", record);
        return "views/record/edit";
    }
    
    @PostMapping(value = "/record/edit/{id}")
    public String edit(@PathVariable("id")long id,
            @ModelAttribute("record")Record record){
        record.setRecordID(id);
        recordService.save(record);
        return "redirect:/record/list";
    }
    
    @GetMapping(value = "/record/delete/{id}")
    public String delete(@PathVariable("id")long id){
        recordService.delete(id);
        return "redirect:/record/list";
    }
}
