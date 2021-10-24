package pl.clockworkjava.advanced.jpa.domain;

import javax.persistence.*;

@Entity
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;

    @OneToOne
    private Student owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Student getOwner() {
        return owner;
    }

    public void setOwner(Student owner) {
        this.owner = owner;
    }

    public Index() {
    }

    public Index(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Index{" +
                "id=" + id +
                ", number='" + number + '\'' +
//                ", owner=" + owner +
                '}';
    }
}
