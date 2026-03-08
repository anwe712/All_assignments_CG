package com.employee.service;

import com.employee.dao.AddressDAO;
import com.employee.entity.Address;

public class AddressService {

AddressDAO dao = new AddressDAO();

public Address getAddress(int id){
return dao.getAddressById(id);
}

public void update(Address add){
dao.updateAddress(add);
}

public void delete(int id){
dao.deleteAddress(id);
}

}