package com.ems.controller;

import com.ems.model.Designation;
import com.ems.services.DesginationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/desgination")
public class DesignationController {
    
    @Autowired
    private DesginationService desginationService;

    @PostMapping(value = "/")
    // @ResponseBody
    public String addDesgination(@ModelAttribute("designation") Designation designation) {
        this.desginationService.addDesgination(designation);
        // return "Successfully added Desgination !!";
        return "admin_userdashboard";
    }
}
