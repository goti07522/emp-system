package com.ems.services;

import java.util.List;

import com.ems.model.Department;
import com.ems.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
  
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(Department department) {
        return this.departmentRepository.save(department);
    }

    public Department getDepartment(Long deptId) {
        return this.departmentRepository.findById(deptId).get();
    }

    public List<Department> getAllDepartment() {
        return this.departmentRepository.findAll();
    }
   
    public int getCount() {
    	return (int) this.departmentRepository.count();
    }
}
