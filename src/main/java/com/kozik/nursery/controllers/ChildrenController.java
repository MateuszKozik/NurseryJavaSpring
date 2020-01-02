package com.kozik.nursery.controllers;

import com.kozik.nursery.entities.Child;
import com.kozik.nursery.entities.Parent;
import com.kozik.nursery.services.ChildService;
import com.kozik.nursery.services.ParentService;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChildrenController {

    @Autowired
    private UserService userService;
    @Autowired
    private ParentService parentService;
    @Autowired
    private ChildService childService;

    @GetMapping(value = "/customer/children")
    public String children(Principal principal, Model model) {
        String email = principal.getName();
        Parent parent = parentService.getByEmail(email);
        List<Child> childList = childService.getByParent(parent);
        model.addAttribute("childList", childList);
        return "views/customer/children";
    }

    @PostMapping(value = "/customer/children")
    public String children(@RequestParam(name = "pesel", required = false) String pesel,
            Principal principal, Model model) {
        String email = principal.getName();
        if (parentService.isParentPresent(email)) {
            if (childService.isChildPresent(pesel)) {
                Child child = childService.get(pesel);
                Parent parent = parentService.getByEmail(email);
                List<Child> childList = childService.getByParent(parent);
                Set<Child> children;
                if (!childList.isEmpty()) {
                    children = new HashSet<Child>(childList);
                    children.add(child);
                } else {
                    children = new HashSet<Child>();
                    children.add(child);
                }
                parent.setChildren(children);
                parentService.save(parent);
                return "redirect:/customer/children";
            } else {
                return "redirect:/customer/children/add";
            }
        } else {
            model.addAttribute("profile", true);
            return "views/customer/children";
        }
    }

    @GetMapping(value = "/customer/children/add")
    public String add(Model model) {
        Child child = new Child();
        model.addAttribute("child", child);
        return "views/customer/addChildren";
    }

    @PostMapping(value = "/customer/children/add")
    public String add(@ModelAttribute("child") Child child,
            Principal principal, Model model) {
        String email = principal.getName();
        if (parentService.isParentPresent(email)) {
            if (childService.isChildPresent(child.getPesel())) {
                return "redirect:/customer/children";
            }
            Parent parent = parentService.getByEmail(email);
            childService.save(child);
            List<Child> childList = childService.getByParent(parent);
            Set<Child> children;
            if (!childList.isEmpty()) {
                children = new HashSet<Child>(childList);
                children.add(child);
            } else {
                children = new HashSet<Child>();
                children.add(child);
            }
            parent.setChildren(children);
            parentService.save(parent);
            return "redirect:/customer/children";
        } else {
            model.addAttribute("profile", true);
            return "views/customer/children";
        }
    }
}
