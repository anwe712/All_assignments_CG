package com.capgemini.entity;

import javax.persistence.*;

@Entity
@Table(name = "salary_record")
public class SalaryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String employeeCode;

    private double baseSalary;
    private double bonus;
    private double tax;
    private double netSalary;

    private String salaryMonth;

    public void calculateNetSalary() {
        this.netSalary = baseSalary + bonus - tax;
    }

    // getters & setters
}