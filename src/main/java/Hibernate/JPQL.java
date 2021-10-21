package Hibernate;

import pl.clockworkjava.advanced.threads.jpa.QueryResult;
import pl.clockworkjava.advanced.threads.jpa.domain.Student;
import javax.persistence.*;


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

        TypedQuery<QueryResult> group = em.createQuery("SELECT new pl.clockworkjava.advanced.threads.jpa.QueryResult(s.name, COUNT(s)) FROM Student s GROUP BY s.name", QueryResult.class);
//        group.getResultList().forEach(System.out::println);
//        q.getResultList().forEach(System.out::println);

        em.createNamedQuery("Student.getAll", Student.class).getResultList().forEach(System.out::println);
        em.createNamedQuery("Student.byName", Student.class).setParameter("name", "John").getResultList().forEach(System.out::println);
    }

    private static void createData() {
        em.getTransaction().begin();
        em.merge(new Student("John", "3333"));
        em.merge(new Student("Joanna", "2465"));
        em.merge(new Student("Joanna", "2499"));
        em.merge(new Student("Joanna", "2586"));
        em.getTransaction().commit();
    }
}
