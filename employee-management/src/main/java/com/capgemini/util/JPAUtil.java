package com.capgemini.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("ems-pu");

    public static EntityManagerFactory getFactory() {
        return emf;
    }
}