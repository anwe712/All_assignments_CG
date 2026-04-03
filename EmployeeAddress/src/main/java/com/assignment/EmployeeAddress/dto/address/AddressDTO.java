package com.assignment.EmployeeAddress.dto.address;

import com.assignment.EmployeeAddress.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {

    private Long id;

    private String street;
    private String city;
    private String state;
    private String country;
    private Long pin;
    private Long emp_id ;

}