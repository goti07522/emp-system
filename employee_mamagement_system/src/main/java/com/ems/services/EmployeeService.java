package com.ems.services;

import java.util.List;

import com.ems.model.Employee;
import com.ems.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public Employee addEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

    public Employee getEmployee(String email){
        return this.employeeRepository.findByEmail(email);
    }

    public List<Employee> getEmployees(){
        return this.employeeRepository.findAll();
    }
    
    public Employee getEmpById(Long id) {
    	return this.employeeRepository.findById(id).get();
    }

    public Employee getEmployeeByEmail(String email) {
    	return this.employeeRepository.findByEmail(email);
    }
    
    public void deleteEmp(Long id) {
    	Employee emp = new Employee();
    	emp.setEmpId(id);
    	this.employeeRepository.delete(emp);
    }
    
    public Boolean updateEmp(Employee employee) {
    	Employee findById = this.employeeRepository.findById(employee.getEmpId()).get();
    	if (findById !=null) {
    		this.employeeRepository.save(employee);
			return true;
		}
    	return false;
    }
    
    public int getCount() {
    	return (int) this.employeeRepository.count();
    }
}
