package se.lexicon;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationEx {

    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();
        ex6();
        ex7();
    }
    public static void ex1(){
        Stream<String> skills = Stream.of("Java","Class","Hate");
        long count = skills.count();
        System.out.println("count = " + count);
    }
    public static void ex2(){
        List<Integer> numbers = Arrays.asList(300,7200,500,800,34);
        Comparator<Integer> comparator = (o1, o2) -> o1 - o2;
        Optional<Integer> minResult = numbers.stream().min(comparator);
        if (minResult.isPresent()){
            System.out.println("minResult = " + minResult.get());
        }
        Optional<Integer> maxResult = numbers.stream().max(comparator);
        if (maxResult.isPresent()){
            System.out.println("maxResult: " + maxResult.get());
        }
    }
    public static void ex3(){
        List<String> names = Arrays.asList("Aman","Sarah","Rima","Ross");
        Optional<String> firstName = names.stream().findFirst();
        System.out.println("firstName = " + firstName.orElse("Not Found"));
        System.out.println(names.stream().findAny().orElse("Empty"));

    }
    public static void ex4(){
        List<String> names = Arrays.asList("Aman","Sarah","Rima","Ross");
        Consumer<String> printString = s -> System.out.println(s);
        //names.stream().forEach(s -> System.out.println(s));
        names.stream().forEach(System.out::println);

    }
    public static void ex5(){
        List<String> words = Arrays.asList("I","know","programming","is","really","hard");
        String str = " ";
        String sentence = words.stream().reduce(str, (s1, s2) ->s1 +" " + s2);
        System.out.println("sentence = " + sentence);
        List<Integer> numbers = Arrays.asList(1,23,45,78,90);
        int identity = 1;
      int result = numbers.stream().reduce(1,(integer1, integer2) -> integer1 * integer2);
        System.out.println("result = " + result);

    }
    // Collect
    public  static void ex6(){

        List<String> words = Arrays.asList("Collect","is","useful");
        StringBuilder result = words.stream().collect(StringBuilder:: new, (StringBuilder,s) ->StringBuilder.
                        append(" ").append(s), StringBuilder::append);
        System.out.println("result = " + result);

    }
    // Collect in another easy way
    public static void ex7(){
        List<String> words = Arrays.asList("Collect","is","useful");
        Set<String> set = words.stream().collect(Collectors.toSet());
        set.forEach(System.out::println);

        List<String> list= words.stream().collect(Collectors.toList());
        list.forEach(System.out::println);

    }
}
