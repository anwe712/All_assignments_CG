package com.assignment.EmployeeAddress.service;

import com.assignment.EmployeeAddress.dto.employee.EmployeeRequestDTO;
import com.assignment.EmployeeAddress.dto.employee.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO);

    List<EmployeeResponseDTO> getAllEmployees();

    EmployeeResponseDTO getEmployeeById(Long id);

    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO requestDTO);

    void deleteEmployee(Long id);
}
