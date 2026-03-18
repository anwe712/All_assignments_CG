package com.capgemini.dao;

import com.capgemini.entity.SalaryRecord;
import com.capgemini.util.JPAUtil;

import javax.persistence.*;
import java.util.List;

public class SalaryRecordDAO {

    public void insert(SalaryRecord sr) {
        EntityManager em = JPAUtil.getFactory().createEntityManager();
        em.getTransaction().begin();

        sr.calculateNetSalary();
        em.persist(sr);

        em.getTransaction().commit();
        em.close();
    }

    public List<SalaryRecord> getByEmployee(String code) {
        EntityManager em = JPAUtil.getFactory().createEntityManager();

        return em.createQuery(
                "from SalaryRecord where employeeCode = :code",
                SalaryRecord.class)
                .setParameter("code", code)
                .getResultList();
    }

    public SalaryRecord getByMonth(String code, String month) {
        EntityManager em = JPAUtil.getFactory().createEntityManager();

        return em.createQuery(
                "from SalaryRecord where employeeCode = :code and salaryMonth = :month",
                SalaryRecord.class)
                .setParameter("code", code)
                .setParameter("month", month)
                .getSingleResult();
    }
}