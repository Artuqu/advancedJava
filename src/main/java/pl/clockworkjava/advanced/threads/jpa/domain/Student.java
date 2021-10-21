package pl.clockworkjava.advanced.threads.jpa.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQuery(name = "Student.getAll", query = "from Student")
@NamedQuery(name = "Student.byName", query = "SELECT s FROM Student s WHERE s.name=:name")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String phone;

    @Embedded
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    private Index index;

    @ManyToOne
    private University university;

    @ManyToMany
    private Set<Classes> classes;


    public Student(String name) {
        this.name = name;
    }


    private Student() {

    }

    public Student(String name, String indexNumber) {
        this.name = name;
        this.index = new Index(indexNumber);
        this.classes = new HashSet<>();
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

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                ", index=" + index +
                '}';
    }

    public void addClasses(Classes classes) {
        this.classes.add(classes);
    }


}
