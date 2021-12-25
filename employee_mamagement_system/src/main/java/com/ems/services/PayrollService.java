package com.ems.services;

import java.util.List;

import com.ems.model.Payroll;
import com.ems.repository.PayrollRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayrollService {
    
    @Autowired
    private PayrollRepository payrollRepository;
    public List<Payroll> getAllPayrolls(){
        return this.payrollRepository.findAll();
    }

    public List<Payroll> getPayRollByUser(Long empId){
        return this.payrollRepository.findByEmpId(empId);
    }

    public Payroll getPayrollById(Long id){
        return this.payrollRepository.findById(id).get();
    }
}
