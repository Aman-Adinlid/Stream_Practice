package se.lexicon;

import se.lexicon.Model.Gender;
import se.lexicon.Model.Person;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationEx {

    private static Function<Person, LocalDate> birthdateFunction;

    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();
        ex6();
        ex7();
        ex8();
        ex9();
        ex10();
        ex11();
        ex12();
        ex13();
    }

    public static void ex1() {
        Stream<String> skills = Stream.of("Java", "Class", "Hate");
        long count = skills.count();
        System.out.println("count = " + count);
    }

    public static void ex2() {
        List<Integer> numbers = Arrays.asList(300, 7200, 500, 800, 34);
        Comparator<Integer> comparator = (o1, o2) -> o1 - o2;
        Optional<Integer> minResult = numbers.stream().min(comparator);
        if (minResult.isPresent()) {
            System.out.println("minResult = " + minResult.get());
        }
        Optional<Integer> maxResult = numbers.stream().max(comparator);
        if (maxResult.isPresent()) {
            System.out.println("maxResult: " + maxResult.get());
        }
    }

    public static void ex3() {
        List<String> names = Arrays.asList("Aman", "Sarah", "Rima", "Ross");
        Optional<String> firstName = names.stream().findFirst();
        System.out.println("firstName = " + firstName.orElse("Not Found"));
        System.out.println(names.stream().findAny().orElse("Empty"));

    }

    public static void ex4() {
        List<String> names = Arrays.asList("Aman", "Sarah", "Rima", "Ross");
        Consumer<String> printString = s -> System.out.println(s);
        //names.stream().forEach(s -> System.out.println(s));
        names.stream().forEach(System.out::println);

    }

    public static void ex5() {
        List<String> words = Arrays.asList("I", "know", "programming", "is", "really", "hard");
        String str = " ";
        String sentence = words.stream().reduce(str, (s1, s2) -> s1 + " " + s2);
        System.out.println("sentence = " + sentence);
        List<Integer> numbers = Arrays.asList(1, 23, 45, 78, 90);
        int identity = 1;
        int result = numbers.stream().reduce(1, (integer1, integer2) -> integer1 * integer2);
        System.out.println("result = " + result);

    }

    // Collect
    public static void ex6() {

        List<String> words = Arrays.asList("Collect", "is", "useful");
        StringBuilder result = words.stream().collect(StringBuilder::new, (StringBuilder, s) -> StringBuilder.
                append(" ").append(s), StringBuilder::append);
        System.out.println("result = " + result);

    }

    // Collect in another easy way
    public static void ex7() {
        List<String> words = Arrays.asList("Collect", "is", "useful");
        Set<String> set = words.stream().collect(Collectors.toSet());
        set.forEach(System.out::println);

        List<String> list = words.stream().collect(Collectors.toList());
        list.forEach(System.out::println);

    }

    //Filter
    public static void ex8() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7, 8, 9);
        Predicate<Integer> even = n -> n % 2 == 0;
        Stream<Integer> NewStream = numbers.stream().filter(even);
        NewStream.forEach(System.out::println);
        numbers.stream().filter(i -> i > 0).forEach(System.out::println);
    }

    public static void ex9() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Aman", "Svensson", Gender.Female,
                LocalDate.parse("1995-06-01"), true));
        persons.add(new Person("Test", "Test", Gender.Male,
                LocalDate.parse("1996-06-30"), false));
        Predicate<Person> maleCondition = person -> person.getGender() == Gender.Male;
        persons.stream().filter(maleCondition).forEach(System.out::println);
        List<Person> female = persons.stream().filter(person -> person.getGender() == Gender.Female).collect(Collectors.toList());
        female.forEach(System.out::println);
    }

    //skip and limit
    public static void ex10() {
        List<String> names = Arrays.asList("Aman", "Sarah", "Rima", "Ross");
        names.stream().skip(2).limit(3).forEach(System.out::println);
    }

    //Limit and skip
    public static void ex11() {
        Stream<Integer> intStream = Stream.iterate(1, i -> i + 1);
        intStream.limit(10).forEach(System.out::println);

    }

    // map
    public static void ex12() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Aman", "Svensson", Gender.Female,
                LocalDate.parse("1995-06-01"), true));
        persons.add(new Person("Test", "Test", Gender.Male,
                LocalDate.parse("1996-06-30"), false));
        Function<Person, LocalDate> birthdateFunction = person -> person.getBirthDate();
        List<LocalDate> birthDateList = persons.stream().map(birthdateFunction).collect(Collectors.toList());
        birthDateList.forEach(System.out::println);
        Function<Person, String> FullName = person -> person.getFirstName() + " " + person.getLastName();
        List<String> FullNames = persons.stream().map(FullName).collect(Collectors.toList());
        FullNames.forEach(System.out::println);
    }

    // distinct means remove the duplicate values
    public static void ex13() {
        List<String> names = Arrays.asList("Aman", "Sarah", "Rima", "Ross", "Rima");
        names.stream().distinct().forEach(System.out::println);
    }
}
