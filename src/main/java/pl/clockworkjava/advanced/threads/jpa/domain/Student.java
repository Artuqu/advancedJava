package pl.clockworkjava.advanced.threads.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String phone;

    @Embedded
    private Address address;


    public Student(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }


    private Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}