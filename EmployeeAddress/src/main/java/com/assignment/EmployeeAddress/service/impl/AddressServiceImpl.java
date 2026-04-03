package com.assignment.EmployeeAddress.service.impl;

import com.assignment.EmployeeAddress.dto.address.AddressRequestDTO;
import com.assignment.EmployeeAddress.dto.address.AddressResponseDTO;
import com.assignment.EmployeeAddress.entity.Address;
import com.assignment.EmployeeAddress.entity.Employee;
import com.assignment.EmployeeAddress.mapper.AddressMapper;
import com.assignment.EmployeeAddress.repository.AddressRepository;
import com.assignment.EmployeeAddress.repository.EmployeeRepository;
import com.assignment.EmployeeAddress.service.AddressService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final EmployeeRepository employeeRepository;
    private final AddressMapper addressMapper;

    @Override
    public AddressResponseDTO createAddress(AddressRequestDTO requestDTO) {
        Employee employee = getEmployeeById(requestDTO.getEmployeeId());
        Address address = addressMapper.toEntity(requestDTO);
        address.setEmployee(employee);
        attachAddressToEmployee(employee, address);
        Address savedAddress = addressRepository.save(address);
        return addressMapper.toResponseDTO(savedAddress);
    }

    @Override
    public List<AddressResponseDTO> getAllAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(addressMapper::toResponseDTO)
                .toList();
    }

    @Override
    public AddressResponseDTO getAddressById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id: " + id));
        return addressMapper.toResponseDTO(address);
    }

    @Override
    public AddressResponseDTO updateAddress(Long id, AddressRequestDTO requestDTO) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id: " + id));

        Employee employee = address.getEmployee();
        if (requestDTO.getEmployeeId() != null) {
            employee = getEmployeeById(requestDTO.getEmployeeId());
        }

        addressMapper.updateEntity(address, requestDTO, employee);
        attachAddressToEmployee(employee, address);
        Address updatedAddress = addressRepository.save(address);
        return addressMapper.toResponseDTO(updatedAddress);
    }

    @Override
    public void deleteAddress(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id: " + id));
        addressRepository.delete(address);
    }

    private Employee getEmployeeById(Long employeeId) {
        if (employeeId == null) {
            throw new IllegalArgumentException("employeeId is required");
        }

        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + employeeId));
    }

    private void attachAddressToEmployee(Employee employee, Address address) {
        if (employee == null || address == null) {
            return;
        }

        if (employee.getAddresses() == null) {
            employee.setAddresses(new ArrayList<>());
        }

        if (!employee.getAddresses().contains(address)) {
            employee.getAddresses().add(address);
        }
    }
}
