package com.employee.main;

import java.time.LocalDate;

import com.employee.entity.Address;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

public class App {

public static void main(String[] args) {

EmployeeService service = new EmployeeService();

Employee emp = new Employee();
emp.setEmployeeName("Anu");
emp.setEmail("anu@gmail.com");
emp.setGender("Female");
emp.setPassword("123");
emp.setPhone("9876543210");
emp.setSalary(20000);
emp.setDateOfBirth(LocalDate.of(2000,5,10));

Address add = new Address();
add.setStreet("Park Street");
add.setCity("Kolkata");
add.setState("WB");
add.setCountry("India");
add.setPincode("700001");

emp.setAddress(add);

service.addEmployee(emp);

System.out.println("Employee saved successfully");

}

}