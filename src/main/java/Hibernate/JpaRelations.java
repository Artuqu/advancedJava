package Hibernate;

import pl.clockworkjava.advanced.threads.jpa.domain.Student;
import pl.clockworkjava.advanced.threads.jpa.domain.University;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaRelations {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClockPersistence");
    static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        em.getTransaction().begin();
        Student beata = em.merge(new Student("Beata", "22222"));
        University up = em.merge(new University("KSW"));

        beata.setUniversity(up);
        up.addStudent(beata);

        em.getTransaction().commit();
        System.out.println(beata.getUniversity());
        System.out.println(beata);

        University university = em.find(University.class, up.getId());
        System.out.println(university);


    }
}
