package com.ems.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.Department;
import com.ems.model.Designation;
import com.ems.model.Employee;
import com.ems.repository.EmployeeRepository;
import com.ems.services.DepartmentService;
import com.ems.services.DesginationService;
import com.ems.services.EmployeeService;

@Controller
@RequestMapping("/PAYROLL")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private DesginationService desginationService;

	// to add employee in the database table
	@PostMapping("/")
	public String addEmp(@ModelAttribute Employee employee, Model model) {
		if (employee != null) {
			Employee emp = this.employeeService.addEmployee(employee);
		}
		return "redirect:/add-emp";
	}

	@GetMapping("/list-PAYROLL")
	public String listemp(Model model, HttpSession session) {
		session.setAttribute("flag", "");
		;
		List<Employee> employees = this.employeeService.getEmployees();
		for (Employee employee : employees) {
			Department department = this.departmentService.getDepartment(Long.parseLong(employee.getDepartment()));
			employee.setDepartment(department.getDeptName());
			Designation desgination = this.desginationService.getDesgination(Long.parseLong(employee.getRole()));
			employee.setRole(desgination.getTitle());
		}
		;
		if (employees.size() != 0) {
			model.addAttribute("listemp", employees);
		}

		return "list_employee";
	}

	
	
}
