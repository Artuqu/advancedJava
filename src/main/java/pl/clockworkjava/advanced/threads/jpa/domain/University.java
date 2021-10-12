package pl.clockworkjava.advanced.threads.jpa.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private University() {
    }

    @OneToMany
    private Set<Student> students;

    public University(String name) {
        this.students = new HashSet<>();
        this.name = name;
    }

    public void addStudent (Student student){
        students.add(student);
    }
}
