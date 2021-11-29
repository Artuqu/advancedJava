package functional;

import functional.domain.FinalStudent;

import java.util.List;
import java.util.Optional;
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


//        createStreamData()
//                .filter(over30)
//                .map(FinalStudent::getName)
//                .filter(name -> name.startsWith("Mietek"))
//                .map(String::toUpperCase)
//                .forEach(System.out::println);

        Stream<FinalStudent> streamData = createStreamData();
        streamData
                .filter(over30)
                .findFirst().ifPresent(finalStudent -> System.out.println("Mamy studenta " + finalStudent.getName()));

        boolean john = createStreamData()
                .map(FinalStudent::getName)
                .anyMatch(name -> name.equals("John"));
        System.out.println(john);

        boolean b = createStreamData()
                .map(FinalStudent::getAge)
                .allMatch(age -> age > 25);
        System.out.println(b);

        Double sumOfRandomDoubles = Stream.generate(Math::random).limit(10).reduce(0.0, (aDouble, aDouble2) -> aDouble + aDouble2);

        System.out.println("To jest " + sumOfRandomDoubles);

        Optional<Integer> maxAgeOfStudent = createStreamData().map(FinalStudent::getAge).reduce((x, y) -> x > y ? x : y);

        maxAgeOfStudent.ifPresent(System.out::println);

//        System.out.println(streamData);
//        createStreamData()
//                .map(finalStudent -> finalStudent.getFinalIndex())
//                .filter(optionalIndex -> optionalIndex.isPresent())
//                .map(optionalIndex -> optionalIndex.get())
//                .map(finalIndex -> finalIndex.getIndexNumber())
//                .forEach(System.out::println);

    }

    private static void consumeStudents(List<FinalStudent> students, Consumer<FinalStudent> consumer) {
        for (FinalStudent fs : students) {
            consumer.accept(fs);
        }
    }
}
