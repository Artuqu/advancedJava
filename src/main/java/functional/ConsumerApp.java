package functional;

import functional.domain.FinalStudent;
import java.util.List;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static functional.PredicateApp.createData;
import static functional.PredicateApp.createStreamData;


public class ConsumerApp {

    public static void main(String[] args) {

        List<FinalStudent> students = createData();
        Predicate<FinalStudent> over30 = fs -> fs.getAge() > 30;
        Predicate<FinalStudent> under30 = fs -> fs.getAge() < 30;
        Consumer<FinalStudent> printStudentsName = fs -> System.out.println(fs.getName());
        Consumer<String> print = System.out::println;
        Consumer<FinalStudent> printStudentsNameToUppercase = fs -> System.out.println(fs.getName().toUpperCase());
        Supplier<List<FinalStudent>> supplyPredefinedFinalStudent = PredicateApp::createData;
//        FinalStudent finalStudent = supplyPredefinedFinalStudent.get().get(0);
//        finalStudent.getFinalIndex();

        IntPredicate o = new IntPredicate() {
            @Override
            public boolean test(int value) {
                return false;
            }
        };
//       double List
        Supplier<List<FinalStudent>> studentSupplier = PredicateApp::createData;
        BiFunction<FinalStudent, String, FinalStudent> changeIndex = (finalStudent, indexNumber) -> finalStudent.changeIndexNumber(indexNumber);
//        way with method reference
        BiFunction<FinalStudent, String, FinalStudent> changeIndexNumber = FinalStudent::changeIndexNumber;
        Function<FinalStudent, String> getStudentName = FinalStudent::getName;
//        consumeStudents(students, printStudentsName);
//        consumeStudents(filterStudents(students, over30), printStudentsNameToUppercase);

        List<FinalStudent> finalStudents = supplyPredefinedFinalStudent.get();
        finalStudents.stream().filter(over30).map(getStudentName).forEach(print);

        Stream.of("A", "C", "D", "B").forEach(print);
        List<FinalStudent> studentsStream = createData();
        studentsStream.stream().filter(under30).map(getStudentName).forEach(print);

//        Stream.generate(() -> Math.random()).limit(20).forEach(System.out::println);
//        Stream.iterate(0, (i) -> i + 2).limit(10).forEach(System.out::println);

        IntStream.rangeClosed(6, 100).filter(i -> i % 2 == 0).forEach(System.out::println);

        createStreamData()
                .filter(over30)
                .map(FinalStudent::getName)
                .filter(name -> name.startsWith("Mietek"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        createStreamData()
                .map(finalStudent -> finalStudent.getFinalIndex())
                .filter(optionalIndex -> optionalIndex.isPresent())
                .map(optionalIndex -> optionalIndex.get())
                .map(finalIndex -> finalIndex.getIndexNumber())
                .forEach(System.out::println);
    }

    private static void consumeStudents(List<FinalStudent> students, Consumer<FinalStudent> consumer) {
        for (FinalStudent fs : students) {
            consumer.accept(fs);
        }
    }
}
