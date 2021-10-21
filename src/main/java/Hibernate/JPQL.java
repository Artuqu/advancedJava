package Hibernate;

import pl.clockworkjava.advanced.threads.jpa.QueryResult;
import pl.clockworkjava.advanced.threads.jpa.domain.Index;
import pl.clockworkjava.advanced.threads.jpa.domain.Student;

import javax.persistence.*;
import java.util.List;

public class JPQL {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClockPersistence");
    static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        createData();
//        em.createQuery("from Student").getResultList().forEach(System.out::println);
//        em.createQuery("SELECT s.index FROM Student s").getResultList().forEach(System.out::println);
//        List<Index> resultList = em.createQuery("SELECT s.index FROM Student s", Index.class).getResultList();
//        System.out.println(resultList);
        TypedQuery<QueryResult> q = em.createQuery("SELECT new pl.clockworkjava.advanced.threads.jpa.QueryResult(s.name, s.index.number) FROM Student s WHERE s.name IN ('John', 'Joanna')", QueryResult.class);

        q.getResultList().forEach(System.out::println);

    }

    private static void createData() {
        em.getTransaction().begin();
        Student john = em.merge(new Student("John", "3333"));
        Student joanna = em.merge(new Student("Joanna", "2465"));
        em.getTransaction().commit();
    }
}
