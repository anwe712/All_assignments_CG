package com.assignment.EmployeeAddress.service.impl;

import com.assignment.EmployeeAddress.dto.employee.EmployeeRequestDTO;
import com.assignment.EmployeeAddress.dto.employee.EmployeeResponseDTO;
import com.assignment.EmployeeAddress.entity.Employee;
import com.assignment.EmployeeAddress.mapper.EmployeeMapper;
import com.assignment.EmployeeAddress.repository.EmployeeRepository;
import com.assignment.EmployeeAddress.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO) {
        Employee employee = employeeMapper.toEntity(requestDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toResponseDTO(savedEmployee);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toResponseDTO)
                .toList();
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
        return employeeMapper.toResponseDTO(employee);
    }

    @Override
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO requestDTO) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));

        employeeMapper.updateEntity(existingEmployee, requestDTO);
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return employeeMapper.toResponseDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EntityNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }
}
