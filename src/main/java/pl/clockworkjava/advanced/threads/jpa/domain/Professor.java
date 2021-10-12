package pl.clockworkjava.advanced.threads.jpa.domain;

import javax.persistence.*;

@Entity
public class Professor {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String phone;

    @Embedded
    private Address address;


    public Professor(int id, String name, String phone, String street, String postalCode, String apartment, String city) {
        this.id = id;
        this.name = name;
        this.phone = phone;

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
        return "Professor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
