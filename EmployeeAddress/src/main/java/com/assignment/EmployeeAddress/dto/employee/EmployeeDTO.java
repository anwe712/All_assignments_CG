package com.assignment.EmployeeAddress.dto.employee;

import com.assignment.EmployeeAddress.dto.address.AddressDTO;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {

    private Long id;

    private String name;
    private String email;
    private String phone;
    private String gender;
    private String designation;
    private Double salary;
    private LocalDate dateOfJoining;

    private AddressDTO address;
}