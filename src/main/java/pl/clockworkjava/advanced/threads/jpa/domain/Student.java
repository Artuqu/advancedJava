package pl.clockworkjava.advanced.threads.jpa.domain;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String phone;

    @Embedded
    private Address address;

    @OneToOne (cascade = CascadeType.ALL)
    private Index index;


    public Student(String name) {
        this.name = name;
    }


    private Student() {

    }

    public Student(String name, String indexNumber) {
        this.name = name;
        this.index = new Index(indexNumber);
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
}
