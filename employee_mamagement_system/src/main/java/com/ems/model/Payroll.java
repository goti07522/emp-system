package com.ems.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payroll_t")
public class Payroll {
    
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long payId;
        private Long empId;
        private String name;
        private String department;
	    private String role;
        private String month;
        private String year;
        private String salary;
        private String da;
        private String gp;
        private String pf;
        private String O_Pay;
        private String netpay;
        public Long getPayId() {
            return payId;
        }
        public void setPayId(Long payId) {
            this.payId = payId;
        }
        public Long getEmpId() {
            return empId;
        }
        public void setEmpId(Long empId) {
            this.empId = empId;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getDepartment() {
            return department;
        }
        public void setDepartment(String department) {
            this.department = department;
        }
        public String getRole() {
            return role;
        }
        public void setRole(String role) {
            this.role = role;
        }
        public String getMonth() {
            return month;
        }
        public void setMonth(String month) {
            this.month = month;
        }
        public String getYear() {
            return year;
        }
        public void setYear(String year) {
            this.year = year;
        }
        public String getSalary() {
            return salary;
        }
        public void setSalary(String salary) {
            this.salary = salary;
        }
        public String getDa() {
            return da;
        }
        public void setDa(String da) {
            this.da = da;
        }
        public String getGp() {
            return gp;
        }
        public void setGp(String gp) {
            this.gp = gp;
        }
        public String getPf() {
            return pf;
        }
        public void setPf(String pf) {
            this.pf = pf;
        }
        public String getO_Pay() {
            return O_Pay;
        }
        public void setO_Pay(String o_Pay) {
            O_Pay = o_Pay;
        }
        public String getNetpay() {
            return netpay;
        }
        public void setNetpay(String netpay) {
            this.netpay = netpay;
        }
        @Override
        public String toString() {
            return "Payroll [O_Pay=" + O_Pay + ", da=" + da + ", department=" + department + ", empId=" + empId
                    + ", gp=" + gp + ", month=" + month + ", name=" + name + ", netpay=" + netpay + ", payId=" + payId
                    + ", pf=" + pf + ", role=" + role + ", salary=" + salary + ", year=" + year + "]";
        }

        
        
        
}