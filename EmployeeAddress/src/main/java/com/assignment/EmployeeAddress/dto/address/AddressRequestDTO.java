package com.assignment.EmployeeAddress.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRequestDTO {

    @NotBlank(message = "street name is mandatory")
    private String street;

    @NotBlank(message = "city is mandatory")
    private String city;

    @NotBlank(message = "state is mandatory")
    private String state;

    @NotBlank(message = "country is mandatory")
    private String country;

    @NotNull(message = "pin is mandatory")
    @Positive(message = "pin should be positive")
    private Long pin;

    private Long employeeId;
}
