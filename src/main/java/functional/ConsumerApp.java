package functional;

import functional.domain.FinalStudent;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static functional.PredicateApp.createData;
import static functional.PredicateApp.filterStudents;

public class ConsumerApp {

    public static void main(String[] args) {

        List<FinalStudent> students = createData();
        Consumer<FinalStudent> printStudentsName = fs -> System.out.println(fs.getName());
        Consumer<FinalStudent> printStudentsNameToUppercase = fs -> System.out.println(fs.getName().toUpperCase());

        Predicate<FinalStudent> over30 = fs -> fs.getAge() > 30;
        consumeStudents(students, printStudentsName);

        consumeStudents(filterStudents(students, over30), printStudentsNameToUppercase);

    }

    private static void consumeStudents(List<FinalStudent> students, Consumer<FinalStudent> consumer) {
        for (FinalStudent fs : students) {
            consumer.accept(fs);
        }
    }
}
