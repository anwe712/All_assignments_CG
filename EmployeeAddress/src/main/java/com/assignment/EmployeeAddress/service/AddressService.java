package com.assignment.EmployeeAddress.service;

import com.assignment.EmployeeAddress.dto.address.AddressRequestDTO;
import com.assignment.EmployeeAddress.dto.address.AddressResponseDTO;

import java.util.List;

public interface AddressService {

    AddressResponseDTO createAddress(AddressRequestDTO requestDTO);

    List<AddressResponseDTO> getAllAddresses();

    AddressResponseDTO getAddressById(Long id);

    AddressResponseDTO updateAddress(Long id, AddressRequestDTO requestDTO);

    void deleteAddress(Long id);
}
