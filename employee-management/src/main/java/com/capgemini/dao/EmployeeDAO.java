package com.capgemini.dao;

import com.capgemini.entity.Employee;
import com.capgemini.util.JPAUtil;

import javax.persistence.*;
import java.util.List;

public class EmployeeDAO {

    public void insert(Employee emp) {
        EntityManager em = JPAUtil.getFactory().createEntityManager();
        em.getTransaction().begin();

        em.persist(emp);

        em.getTransaction().commit();
        em.close();
    }

    public Employee getByCode(String code) {
        EntityManager em = JPAUtil.getFactory().createEntityManager();

        TypedQuery<Employee> q = em.createQuery(
                "from Employee where employeeCode = :code", Employee.class);
        q.setParameter("code", code);

        return q.getSingleResult();
    }

    public void updateName(String code, String newName) {
        EntityManager em = JPAUtil.getFactory().createEntityManager();
        em.getTransaction().begin();

        Employee emp = getByCode(code);
        emp.setName(newName);

        em.merge(emp);

        em.getTransaction().commit();
        em.close();
    }

    public void softDelete(String code) {
        EntityManager em = JPAUtil.getFactory().createEntityManager();
        em.getTransaction().begin();

        Employee emp = getByCode(code);
        emp.setActive(false);

        em.merge(emp);

        em.getTransaction().commit();
        em.close();
    }

    public List<Employee> getActiveEmployees() {
        EntityManager em = JPAUtil.getFactory().createEntityManager();

        return em.createQuery(
                "from Employee where active = true", Employee.class)
                .getResultList();
    }
}