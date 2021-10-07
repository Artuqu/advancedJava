package Hibernate;

import pl.clockworkjava.advanced.threads.jpa.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JpaApp {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClockPersistence");
    static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {

//Create
        createStudent();
//Read
        readStudents();
// Update
        updateStudent();
// Delete

        deleteStudent();
    }

    private static void deleteStudent() {
        Student student = em.find(Student.class, 0);
        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
    }

    private static void updateStudent() {
    Student kinga = new Student(3, "Kinga", "229900");
        em.getTransaction().begin();
        Student student = em.merge(kinga);

        student.setPhone("330909000");

        em.merge(student);
        em.getTransaction().commit();
    }

    private static void readStudents() {
//        Student students = em.find(Student.class, 0);
//        System.out.println(students);
        List students = em.createQuery("from Student").getResultList();
        students.forEach(System.out::println);
    }

    private static void createStudent() {
        Student pawel = new Student(0, "Paweł", "0332332");

        em.getTransaction().begin();
        em.persist(pawel);
        em.getTransaction().commit();
    }
}
