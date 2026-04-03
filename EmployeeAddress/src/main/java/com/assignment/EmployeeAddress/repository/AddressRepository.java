package com.assignment.EmployeeAddress.repository;

import com.assignment.EmployeeAddress.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
