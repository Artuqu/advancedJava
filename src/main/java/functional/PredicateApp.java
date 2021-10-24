package functional;

import functional.domain.FinalStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateApp {

    public static void main(String[] args) {

        List<FinalStudent> students = createData();

        Predicate<FinalStudent> isMark = f -> f.getName().equals("Marek");

//        Predicate<FinalStudent> over30 = (FinalStudent fs) -> fs.getAge() > 30;
        Predicate<FinalStudent> over30 = fs -> fs.getAge() > 30;
//        joining Predicate
        Predicate<FinalStudent> and = isMark.and(over30);

        filterStudents(students, over30);
        filterStudents(students, isMark);
        filterStudents(students, and);

    }

    public static List<FinalStudent> filterStudents(List<FinalStudent> students, Predicate<FinalStudent> predicate) {
        List<FinalStudent> result = new ArrayList<>();
        for (FinalStudent fs : students) {
            if (predicate.test(fs)) {
                result.add(fs);
            }
        }
        System.out.println(result);
        return result;
    }

    public static List<FinalStudent> createData() {
        List<FinalStudent> result = new ArrayList<>();
        result.add(new FinalStudent("Marek", 30, "5678"));
        result.add(new FinalStudent("Marcin", 33, "5679"));
        result.add(new FinalStudent("Michał", 22, "5680"));
        return result;
    }
}
