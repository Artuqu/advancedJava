package hibernate;

import pl.clockworkjava.advanced.jpa.domain.Student;
import pl.clockworkjava.advanced.jpa.domain.University;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fetch {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClockPersistenceProd");
    static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        createData();
        em.createQuery("from University").getResultList().forEach(System.out::println);
    }
    private static void createData() {
        em.getTransaction().begin();
        Student john = em.merge(new Student("John", "3333"));
        Student joanna = em.merge(new Student("Joanna", "2465"));
        University up = em.merge(new University("UP"));
        up.addStudent(joanna);
        up.addStudent(john);

//        em.clear();
        em.getTransaction().commit();

    }
}
