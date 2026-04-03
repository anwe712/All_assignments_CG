package com.assignment.EmployeeAddress.dto.employee;

import com.assignment.EmployeeAddress.dto.address.AddressRequestDTO;
import com.assignment.EmployeeAddress.dto.address.AddressResponseDTO;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeResponseDTO {

    private Long id;

    private String name;
    private String email;
    private String phone;
    private String gender;
    private String designation;
    private Double salary;
    private LocalDate dateOfJoining;

    private AddressResponseDTO address;
}