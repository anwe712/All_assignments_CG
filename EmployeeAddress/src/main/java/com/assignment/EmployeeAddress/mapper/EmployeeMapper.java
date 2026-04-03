package com.assignment.EmployeeAddress.mapper;

import com.assignment.EmployeeAddress.dto.address.AddressResponseDTO;
import com.assignment.EmployeeAddress.dto.employee.EmployeeRequestDTO;
import com.assignment.EmployeeAddress.dto.employee.EmployeeResponseDTO;
import com.assignment.EmployeeAddress.entity.Address;
import com.assignment.EmployeeAddress.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class EmployeeMapper {

    private final AddressMapper addressMapper;

    public EmployeeMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public Employee toEntity(EmployeeRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Employee employee = new Employee();
        applyEmployeeFields(employee, dto);

        Address address = addressMapper.toEntity(dto.getAddress());
        if (address != null) {
            address.setEmployee(employee);
            employee.setAddresses(Collections.singletonList(address));
        }

        return employee;
    }

    public EmployeeResponseDTO toResponseDTO(Employee employee) {
        if (employee == null) {
            return null;
        }

        AddressResponseDTO addressResponseDTO = null;
        if (employee.getAddresses() != null && !employee.getAddresses().isEmpty()) {
            addressResponseDTO = addressMapper.toResponseDTO(employee.getAddresses().get(0));
        }

        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
        responseDTO.setId(employee.getId());
        responseDTO.setName(employee.getName());
        responseDTO.setEmail(employee.getEmail());
        responseDTO.setPhone(employee.getPhone());
        responseDTO.setGender(employee.getGender());
        responseDTO.setDesignation(employee.getDesignation());
        responseDTO.setSalary(employee.getSalary());
        responseDTO.setDateOfJoining(employee.getDateOfJoining());
        responseDTO.setAddress(addressResponseDTO);
        return responseDTO;
    }

    public void updateEntity(Employee employee, EmployeeRequestDTO dto) {
        if (employee == null || dto == null) {
            return;
        }

        applyEmployeeFields(employee, dto);

        Address address;
        if (employee.getAddresses() != null && !employee.getAddresses().isEmpty()) {
            address = employee.getAddresses().get(0);
            addressMapper.updateEntity(address, dto.getAddress(), employee);
        } else {
            address = addressMapper.toEntity(dto.getAddress());
            if (address != null) {
                address.setEmployee(employee);
                employee.setAddresses(Collections.singletonList(address));
            }
        }
    }

    private void applyEmployeeFields(Employee employee, EmployeeRequestDTO dto) {
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setGender(dto.getGender());
        employee.setDesignation(dto.getDesignation());
        employee.setSalary(dto.getSalary());
        employee.setDateOfJoining(dto.getDateOfJoining());
    }
}
