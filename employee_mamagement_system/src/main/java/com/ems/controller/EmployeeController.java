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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.Department;
import com.ems.model.Designation;
import com.ems.model.Employee;
import com.ems.model.Payroll;
import com.ems.repository.EmployeeRepository;
import com.ems.services.DepartmentService;
import com.ems.services.DesginationService;
import com.ems.services.EmployeeService;
import com.ems.services.PayrollService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private DesginationService desginationService;

	@Autowired
	private PayrollService payrollService;

	// to add employee in the database table
	@PostMapping("/")
	public String addEmp(@ModelAttribute Employee employee, Model model) {
		if (employee != null) {
			Employee emp = this.employeeService.addEmployee(employee);
		}
		return "redirect:/add-emp";
	}

	@GetMapping("/list-emp")
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

	@GetMapping("/delete-emp/{id}")
	public String deleteEmp(@PathVariable("id") Long id) {
		this.employeeService.deleteEmp(id);
		System.out.println("Deleted");
		return "redirect:/employee/list-emp";
	}
	@GetMapping("/user")
	public String userDashboard(HttpSession httpSession,Model model) {
		Employee user = (Employee) httpSession.getAttribute("user");
		model.addAttribute("title", "Employee Dashboard");
		model.addAttribute("employee", user);
		return "user";
	}

	@PostMapping("/edit")
	public String editEmp(@ModelAttribute Employee employee) {
		this.employeeService.updateEmp(employee);
		return "redirect:/employee/list-emp";
	}

	@PostMapping("/do-login")
	public String doLogin(HttpSession httpSession,@RequestParam("email") String email, @RequestParam("password") String password) {
		Employee employeeByEmail = null;
		try {
			employeeByEmail = this.employeeService.getEmployeeByEmail(email);
			if (employeeByEmail.getEmail().equals("amit@gmail.com")) {
				if (employeeByEmail.getPassword().equals(password)) {
					httpSession.setAttribute("user", employeeByEmail);
					return "redirect:/admin";
				}
			} else {
				if (employeeByEmail.getPassword().equals(password)) {
					httpSession.setAttribute("user", employeeByEmail);
					return "redirect:/employee/user";
				}
			}
		} catch (Exception e) {
			return "redirect:/login";
		}

		return "redirect:/login";
	}

	@GetMapping("/list-emp-slips")
	public String slips(HttpSession httpSession,Model model) {
		Employee employee = (Employee) httpSession.getAttribute("user");
		List<Payroll> payRollByUser = this.payrollService.getPayRollByUser(employee.getEmpId());
		model.addAttribute("allPayroll", payRollByUser);
		return "slips";
	}
	
	@GetMapping("/payroll/{id}")
	public String payroll(@PathVariable("id") Long id, Model model) {
		Payroll payrollById = this.payrollService.getPayrollById(id);
		model.addAttribute("employee", payrollById);
		return "month_slip";
	}

	@GetMapping("/obj-emp")
	public String objemp() {
		return "objection";
	}
	


}
