package org.example.beans.utils;

import org.example.beans.Person;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListParser {
    public static Map<String, List<Person>> groupByCountry(List<Person> personList) {
        return personList.stream()
                .collect(Collectors.groupingBy(Person::getCountry));
    }
    public static Map<Integer, List<Person>> groupByAge(List<Person> personList) {
        return personList.stream()
                .collect(Collectors.groupingBy(Person::getAge));
    }

    public static Map<Double, List<Person>> groupBySalary(List<Person> personList) {
        return personList.stream()
                .collect(Collectors.groupingBy(Person::getSalary));
    }

    public static double countAverageSalary(List<Person> personList) {
        return personList.stream()
                .mapToDouble(Person::getSalary)
                .average()
                .getAsDouble();
    }

    public static double countAveageAge(List<Person> personList) {
        return personList.stream()
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
    }

    public static List<Person> whoLikesWine(List<Person> personList) {//uzycie anyMatch, znajduje persony, które mają wine w beverages
        return personList.stream()
                .filter(person ->
                        person.getBeverages().stream()
                                .anyMatch(beverage -> beverage.getName().equals("Wine")))
                .collect(Collectors.toList());
    }

    public static List<Person> whoLikesMilk(List<Person> personList) {
        return personList.stream()
                .filter(person ->
                        person.getBeverages().stream()
                                .anyMatch(beverage -> beverage.getName().equals("Milk")))
                .collect(Collectors.toList());
    }

    public static List<Person> whoLikesCoffe(List<Person> personList) {
        return personList.stream()
                .filter(person ->
                        person.getBeverages().stream()
                                .anyMatch(beverage -> beverage.getName().equals("Coffe")))
                .collect(Collectors.toList());
    }

    public static List<Integer> flattenList(List<List<Integer>> listOfLists) {
        List<Integer> flattenList = listOfLists.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        return flattenList;
    }

    public static List<Integer> flattenAndTransform(List<List<Integer>> listOfLists, Function<Integer, Integer> function) {
        List<Integer> flattenList = listOfLists.stream()
                .flatMap(list -> list.stream().map(function))//mapowanie w tym miejscu znaczy mapowanie strumieni list, a nie jednego większego strumienia
                .collect(Collectors.toList());
        return flattenList;
    }

    public static List<Integer> flattenAndFilterList(List<List<Integer>> listOfLists, Predicate<Integer> predicate) {
        return listOfLists.stream()
                .flatMap(list -> list.stream())
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static List<Integer> flattenAndDistictAndSortedList(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(list -> list.stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public static int getSum(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static double getAvg(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(Double.MAX_VALUE);
    }

    public static int getMax(List<Integer> integerList) {
        int max = integerList.stream()
                .max(Comparator.comparing(Integer::intValue)).orElse(Integer.MAX_VALUE);
        return max;
    }

    public static int getMin(List<Integer> integerList) {
        int min = integerList.stream()
                .min(Comparator.comparing(Integer::intValue)).orElse(Integer.MIN_VALUE);
        return min;
    }

    public static List<Integer> flattenAndDistinctAndSortedWithLimit(List<List<Integer>> listOfLists ,long limit) {
        return listOfLists.stream()
                //.peek(Consumers.printListOfListsConsumer)     //nie działa...
                .flatMap(list -> list.stream())
                .distinct()
                .sorted()
                .limit(limit)
                .collect(Collectors.toList());
    }

    public static DoubleSummaryStatistics getDoubleSummaryStatistics(List<Integer> integerList) {
        return integerList.stream()
                .mapToDouble(Integer::doubleValue)
                .summaryStatistics();
    }

    public static Map<Integer, Integer> mapIdsToBeveragesSize(List<Person> people) {
        return people.stream()
                .collect(Collectors.toMap(
                                Person::getId, person -> person.getBeverages().size()
                        )
                );
    }

    public static Map<String, List<String>> countriesToNamesMap(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(
                        Person::getCountry,     //grupowanie wg Country
                        Collectors.mapping(Person::getName, Collectors.toList()))  // łączenie properties do 1-dnej listy
                );
    }

    public static Map<String, List<Set<String>>> countriesTOSetsOfBeveragesNames(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(
                        Person::getCountry,
                        Collectors.mapping(
                                person -> person.getBeverages()
                                        .stream()
                                        .map(beverage -> beverage.getName())
                                        .collect(Collectors.toSet()),
                                Collectors.toList())));
    }

    public static Map<String, List<String>> countriesToBeveregesNamesMap(Map<String, List<Set<String>>> countriesTOSetsOfBeveragesNames) {
        return countriesTOSetsOfBeveragesNames.keySet().stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        key -> countriesTOSetsOfBeveragesNames.get(key).stream()
                                .flatMap(list -> list.stream().distinct())//distinct nie zadziała, bo to intermediate operation
                                .collect(Collectors.toList()))
                );
    }

    public static Map<String, List<String>> countriesToDistinctBeveregesNamesMap(Map<String, List<String>> countriesToBeveregesNamesMap) {
        return countriesToBeveregesNamesMap.keySet().stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        key -> countriesToBeveregesNamesMap.get(key).stream()
                                .distinct().collect(Collectors.toList())
                ));
    }

}

