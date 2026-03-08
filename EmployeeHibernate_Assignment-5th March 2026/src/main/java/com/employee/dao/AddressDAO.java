package com.employee.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.employee.entity.Address;
import com.employee.util.HibernateUtil;

public class AddressDAO {

public void updateAddress(Address address){

Session session = HibernateUtil.getFactory().openSession();
Transaction tx = session.beginTransaction();

session.update(address);

tx.commit();
session.close();

}

public Address getAddressById(int id){

Session session = HibernateUtil.getFactory().openSession();

Address add = session.get(Address.class,id);

session.close();
return add;

}

public void deleteAddress(int id){

Session session = HibernateUtil.getFactory().openSession();
Transaction tx = session.beginTransaction();

Address add = session.get(Address.class,id);
session.delete(add);

tx.commit();
session.close();

}

}