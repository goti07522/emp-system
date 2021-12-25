package com.ems.repository;

import java.util.List;

import com.ems.model.Payroll;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Long>{

    public Payroll findByEmpIdAndMonth(Long empId,String month);

    public List<Payroll> findByEmpId(Long empId);
    
}
