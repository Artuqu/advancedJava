package functional.domain;

import java.util.Objects;
import java.util.Optional;

final public class FinalStudent implements Comparable<FinalStudent> {

    private String name;
    private int age;
    private FinalIndex finalIndex;

    public FinalStudent(String name, int age, String indexNumber) {
        this.name = name;
        this.age = age;
        this.finalIndex = new FinalIndex(indexNumber);
    }

    public FinalStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Optional<FinalIndex> getFinalIndex() {
        return Optional.ofNullable(this.finalIndex);
    }

    public String getStudentInfo() {
        return this.name + " " + this.age;
    }

    @Override
    public String toString() {
        return "FinalStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", finalIndex=" + finalIndex +
                '}';
    }


    public FinalStudent changeIndexNumber(String newIndexNumber) {
        return new FinalStudent(this.name, this.age, newIndexNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinalStudent that = (FinalStudent) o;
        return Objects.equals(finalIndex, that.finalIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(finalIndex);
    }

    @Override
    public int compareTo(FinalStudent o) {
     return this.name.compareTo(o.getName());
    }
}
