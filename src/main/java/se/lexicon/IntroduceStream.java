package se.lexicon;

import se.lexicon.Model.Gender;
import se.lexicon.Model.Person;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntroduceStream {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Aman","Svensson", Gender.Female,
                LocalDate.parse("1995-06-01"),true));
        persons.add(new Person("Test","Test",Gender.Male,
                LocalDate.parse("1996-06-30"),false));
        Predicate<Person> leapYear = person -> person.getBirthDate().isLeapYear();
        persons.stream().filter(leapYear).forEach(System.out::println);
        System.out.println("_________________________");
       List<Person> personsNameAman =persons.stream().filter(person -> person.getFirstName().equals("Aman")).collect(Collectors.toList());
        personsNameAman.forEach(System.out::println);




        Stream<String> empty = Stream.empty();
        Stream<Integer> SingleElement = Stream.of(1);
        Stream<Double>  fromArray = Stream.of(1.12,3.14,5.67);

          String[] names = {"me","u"};
          Stream<String> StreamNames = Arrays.stream(names);


    }

}
