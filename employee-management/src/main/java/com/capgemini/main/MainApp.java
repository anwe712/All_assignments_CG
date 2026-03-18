package com.capgemini.main;

import com.capgemini.dao.EmployeeDAO;
import com.capgemini.dao.SalaryRecordDAO;
import com.capgemini.dao.PerformanceReviewDAO;

import com.capgemini.entity.Employee;
import com.capgemini.entity.SalaryRecord;
import com.capgemini.entity.PerformanceReview;

import java.time.LocalDate;

public class MainApp {

    public static void main(String[] args) {

        EmployeeDAO empDAO = new EmployeeDAO();
        SalaryRecordDAO salDAO = new SalaryRecordDAO();
        PerformanceReviewDAO reviewDAO = new PerformanceReviewDAO();

    
        Employee emp = new Employee();
        emp.setEmployeeCode("EMP101");
        emp.setName("Anu");
        emp.setEmail("anu@gmail.com");
        emp.setDepartment("IT");
        emp.setDesignation("engineer");
        emp.setJoiningDate(LocalDate.now());

        empDAO.insert(emp);
}
}