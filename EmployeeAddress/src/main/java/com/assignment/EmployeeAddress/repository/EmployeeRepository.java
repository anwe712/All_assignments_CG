package com.assignment.EmployeeAddress.repository;

import com.assignment.EmployeeAddress.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
