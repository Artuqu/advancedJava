package Hibernate;

import pl.clockworkjava.advanced.threads.jpa.domain.Index;
import pl.clockworkjava.advanced.threads.jpa.domain.Student;
import pl.clockworkjava.advanced.threads.jpa.domain.University;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JpaApp {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClockPersistence");
    static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

//Create
//        createStudent();
//Read
//        readStudents();
// Update
//        updateStudent();
// Delete

//        deleteStudent();
//

        em.getTransaction().begin();
        Student kamil = em.merge(new Student( "Kamil", "0000"));
        Index index = em.merge(new Index("1234"));
        kamil.setIndex(index);
//
//      System.out.println(index);
        System.out.println(kamil);
//
//        index.setOwner(kamil);
//        Index findOwner = em.find(Index.class, 2);
//        System.out.println(findOwner);

        University umk = em.merge(new University("UMK"));
        umk.addStudent(kamil);
        em.getTransaction().commit();
    }

    private static void deleteStudent() {
        Student student = em.find(Student.class, 1);
        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
    }

    private static void updateStudent() {
        Student kinga = new Student("Kinga", "229900");
        em.getTransaction().begin();
        Student student = em.merge(kinga);

        student.setPhone("330909000");

        em.merge(student);
        em.getTransaction().commit();
    }

    private static void readStudents() {
//        Student students = em.find(Student.class, 1);
//        System.out.println(students);
        List students = em.createQuery("from Student").getResultList();
        students.forEach(System.out::println);
    }

    private static void createStudent() {
        Student pawel = new Student("Paweł", "0332332");

        em.getTransaction().begin();
        em.persist(pawel);
        em.getTransaction().commit();
    }
}
