package com.assignment.EmployeeAddress.mapper;

import com.assignment.EmployeeAddress.dto.address.AddressRequestDTO;
import com.assignment.EmployeeAddress.dto.address.AddressResponseDTO;
import com.assignment.EmployeeAddress.entity.Address;
import com.assignment.EmployeeAddress.entity.Employee;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address toEntity(AddressRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        validatePin(dto);

        Address address = new Address();
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setCountry(dto.getCountry());
        address.setPincode(dto.getPin());
        return address;
    }

    public AddressResponseDTO toResponseDTO(Address address) {
        if (address == null) {
            return null;
        }

        Long employeeId = null;
        if (address.getEmployee() != null) {
            employeeId = address.getEmployee().getId();
        }

        return AddressResponseDTO.builder()
                .id(address.getId())
                .street(address.getStreet())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .pin(address.getPincode())
                .employeeId(employeeId)
                .build();
    }

    public void updateEntity(Address address, AddressRequestDTO dto, Employee employee) {
        if (address == null || dto == null) {
            return;
        }
        validatePin(dto);

        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setCountry(dto.getCountry());
        address.setPincode(dto.getPin());
        address.setEmployee(employee);
    }

    private void validatePin(AddressRequestDTO dto) {
        if (dto.getPin() == null) {
            throw new ValidationException("pin is mandatory");
        }
    }
}
