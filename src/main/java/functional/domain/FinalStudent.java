package functional.domain;

import java.util.Optional;

final public class FinalStudent {

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
}
