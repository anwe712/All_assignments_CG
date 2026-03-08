package com.employee.service;

import java.util.List;

import com.employee.dao.EmployeeDAO;
import com.employee.entity.Employee;

public class EmployeeService {

EmployeeDAO dao = new EmployeeDAO();

public void addEmployee(Employee emp){
dao.saveEmployee(emp);
}

public Employee getEmployee(int id){
return dao.getEmployeeById(id);
}

public List<Employee> getAll(){
return dao.getAllEmployees();
}

public void update(Employee emp){
dao.updateEmployee(emp);
}

public void delete(int id){
dao.deleteEmployee(id);
}

}