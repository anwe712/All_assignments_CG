package com.assignment.EmployeeAddress.controller;

import com.assignment.EmployeeAddress.dto.address.AddressRequestDTO;
import com.assignment.EmployeeAddress.dto.address.AddressResponseDTO;
import com.assignment.EmployeeAddress.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressResponseDTO createAddress(@Valid @RequestBody AddressRequestDTO requestDTO) {
        return addressService.createAddress(requestDTO);
    }

    @GetMapping
    public List<AddressResponseDTO> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public AddressResponseDTO getAddressById(@PathVariable("id") Long id) {
        return addressService.getAddressById(id);
    }

    @PutMapping("/{id}")
    public AddressResponseDTO updateAddress(@PathVariable("id") Long id,
                                            @Valid @RequestBody AddressRequestDTO requestDTO) {
        return addressService.updateAddress(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable("id") Long id) {
        addressService.deleteAddress(id);
    }
}
