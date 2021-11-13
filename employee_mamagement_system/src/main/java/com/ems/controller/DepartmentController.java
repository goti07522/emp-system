package com.ems.controller;

import com.ems.model.Department;
import com.ems.services.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    @ResponseBody
    public String addDepartment(@ModelAttribute("department") Department department) {
        System.out.println(department);
        this.departmentService.addDepartment(department);
        return "Successfully added department !!";
        
    }
    
}
