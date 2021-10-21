package Hibernate;

import pl.clockworkjava.advanced.threads.jpa.domain.Index;
import pl.clockworkjava.advanced.threads.jpa.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JPQL {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClockPersistence");
    static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        createData();
        em.createQuery("from Student").getResultList().forEach(System.out::println);
        em.createQuery("SELECT s.index FROM Student s").getResultList().forEach(System.out::println);
        List<Index> resultList = em.createQuery("SELECT s.index FROM Student s", Index.class).getResultList();
        System.out.println(resultList);
    }

    private static void createData() {
        em.getTransaction().begin();
        Student john = em.merge(new Student("John", "3333"));
        Student joanna = em.merge(new Student("Joanna", "2465"));
        em.getTransaction().commit();
    }
}
