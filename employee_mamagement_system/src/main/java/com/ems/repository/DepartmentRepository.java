package com.ems.repository;

import com.ems.model.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    
}
