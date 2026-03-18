package com.capgemini.dao;

import com.capgemini.entity.PerformanceReview;
import com.capgemini.util.JPAUtil;

import javax.persistence.*;
import java.util.List;

public class PerformanceReviewDAO {

    public void insert(PerformanceReview pr) {
        EntityManager em = JPAUtil.getFactory().createEntityManager();
        em.getTransaction().begin();

        em.persist(pr);

        em.getTransaction().commit();
        em.close();
    }

    public List<PerformanceReview> getByEmployee(String code) {
        EntityManager em = JPAUtil.getFactory().createEntityManager();

        return em.createQuery(
                "from PerformanceReview where employeeCode = :code",
                PerformanceReview.class)
                .setParameter("code", code)
                .getResultList();
    }
}