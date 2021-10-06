package Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaApp {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClockPersistence");

        EntityManager em = emf.createEntityManager();
    }
}
