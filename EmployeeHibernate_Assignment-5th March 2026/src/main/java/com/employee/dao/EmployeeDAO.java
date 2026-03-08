package com.employee.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.employee.entity.Employee;
import com.employee.util.HibernateUtil;

public class EmployeeDAO {

public void saveEmployee(Employee emp){

Session session = HibernateUtil.getFactory().openSession();
Transaction tx = session.beginTransaction();

session.save(emp);

tx.commit();
session.close();

}

public Employee getEmployeeById(int id){

Session session = HibernateUtil.getFactory().openSession();

Employee emp = session.get(Employee.class,id);

session.close();
return emp;

}

public List<Employee> getAllEmployees(){

Session session = HibernateUtil.getFactory().openSession();

List<Employee> list =
session.createQuery("from Employee",Employee.class).list();

session.close();
return list;

}

public void updateEmployee(Employee emp){

Session session = HibernateUtil.getFactory().openSession();
Transaction tx = session.beginTransaction();

session.update(emp);

tx.commit();
session.close();

}

public void deleteEmployee(int id){

Session session = HibernateUtil.getFactory().openSession();
Transaction tx = session.beginTransaction();

Employee emp = session.get(Employee.class,id);
session.delete(emp);

tx.commit();
session.close();

}

}