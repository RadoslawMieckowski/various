package org.example.mains;

import org.example.beans.Beverage;
import org.example.beans.Person;
import org.example.beans.utils.ListParser;

import java.util.*;
import java.util.stream.Collectors;

import static org.example.beans.utils.ListParser.mapIdsToBeveragesSize;

public class PersonStreamsDemo {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Radek", 10, "Poland", 1, 10,
                        Set.of(new Beverage("Tea"), new Beverage("Wine"))
                ),
                new Person("Simon", 10, "Switzerland", 2, 20,
                        Set.of(new Beverage("Wine"))
                ),
                new Person("Mateusz", 15, "Poland", 3, 20,
                        Set.of(new Beverage("Milk"), new Beverage("Tea"), new Beverage("Water"))),
                new Person("John", 17, "USA", 4, 10,
                        Set.of(new Beverage("Milk"), new Beverage("Coffe"), new Beverage("Water"))),
                new Person("Konrad", 17, "Poland", 5, 40,
                        Set.of(new Beverage("Coffe"), new Beverage("Wine")))
        );

        System.out.println(ListParser.groupByCountry(people));
        System.out.println(ListParser.groupByAge(people));
        System.out.println(ListParser.groupBySalary(people));

        System.out.println(ListParser.countAverageSalary(people));
        System.out.println(ListParser.countAveageAge(people));

        System.out.println(ListParser.whoLikesWine(people));
        System.out.println(ListParser.whoLikesMilk(people));
        System.out.println(ListParser.whoLikesCoffe(people));

        System.out.println(mapIdsToBeveragesSize(people));

        Map<String, List<String>> countriesToNamesMap = ListParser.countriesToNamesMap(people);
        Map<String, List<Set<String>>> countriesTOSetsOfBeveragesNames = ListParser.countriesTOSetsOfBeveragesNames(people);

        System.out.println(countriesToNamesMap);
        System.out.println(countriesTOSetsOfBeveragesNames);

        Map<String, List<String>> countriesToBeveregesNamesMap = ListParser.countriesToBeveregesNamesMap(countriesTOSetsOfBeveragesNames);
        System.out.println(countriesToBeveregesNamesMap);

        Map<String, List<String>> countriesToDistinctBeveregesNamesMap = ListParser.countriesToDistinctBeveregesNamesMap(countriesToBeveregesNamesMap);
        System.out.println(countriesToDistinctBeveregesNamesMap);

    }
}