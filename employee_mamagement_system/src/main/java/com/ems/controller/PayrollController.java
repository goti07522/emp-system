package com.ems.controller;

import com.ems.model.Department;
import com.ems.model.Designation;
import com.ems.model.Employee;
import com.ems.model.Payroll;
import com.ems.repository.PayrollRepository;
import com.ems.services.DepartmentService;
import com.ems.services.DesginationService;
import com.ems.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pay")
public class PayrollController {
	@Autowired
	private PayrollRepository payrollRepository;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private DesginationService desginationService;

	@GetMapping("/payroll/{id}")
	public String payroll(@PathVariable("id") Long id, Model model) {
		Employee employee = this.employeeService.getEmpById(id);
		Department department = this.departmentService.getDepartment(Long.parseLong(employee.getDepartment()));
		employee.setDepartment(department.getDeptName());
		Designation desgination = this.desginationService.getDesgination(Long.parseLong(employee.getRole()));
		employee.setRole(desgination.getTitle());

		model.addAttribute("employee", employee);
		model.addAttribute("payroll", new Payroll());
		model.addAttribute("title", "Payroll");
		return "payroll";
	}

	@PostMapping("/")
	@ResponseBody
	public String doPay(@ModelAttribute Payroll payroll) {
		Payroll payroll1 = this.payrollRepository.findByEmpIdAndMonth(payroll.getEmpId(),payroll.getMonth());
		System.out.println(payroll1);
		// this.payrollRepository.save(payroll);
		this.payrollRepository.flush();
		return "paid";
	}

}
