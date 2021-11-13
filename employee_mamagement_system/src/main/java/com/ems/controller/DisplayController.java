package com.ems.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ems.model.Department;
import com.ems.model.Designation;
import com.ems.model.Employee;
import com.ems.services.DepartmentService;
import com.ems.services.DesginationService;
import com.ems.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DisplayController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private DesginationService desginationService;

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/add-emp")
	public String addEmp(Model model, HttpSession session) {
		List<Department> allDepartment = this.departmentService.getAllDepartment();
		List<Designation> allDesgination = this.desginationService.getAllDesgination();
		model.addAttribute("departments", allDepartment);
		model.addAttribute("roles", allDesgination);
		session.invalidate();
		return "add-employee";
	}

	@GetMapping("/list-emp")
	public String listemp() {
		return "list_employee";
	}

	@GetMapping("/view-emp/{empId}")
	public String viewemp(@PathVariable("empId") Long id, Model model) {
		Employee employee = this.employeeService.getEmpById(id);
		System.out.println(employee);
		model.addAttribute("title", "View Employee");
		model.addAttribute("employee", employee);
		return "view-employee";
	}

	@GetMapping("/edit-emp/{empId}")
	public String editemp(@PathVariable("empId") Long id, Model model) {
		Employee employee = this.employeeService.getEmpById(id);
		List<Department> allDepartment = this.departmentService.getAllDepartment();
		List<Designation> allDesgination = this.desginationService.getAllDesgination();

		model.addAttribute("departments", allDepartment);
		model.addAttribute("roles", allDesgination);
		model.addAttribute("title", "Edit Employee");
		model.addAttribute("employee", employee);
		return "edit-employee";
	}
	
	
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("userCount", this.employeeService.getCount());
		model.addAttribute("deptCount",this.departmentService.getCount());
		return "admin_userdashboard";
	}

}
