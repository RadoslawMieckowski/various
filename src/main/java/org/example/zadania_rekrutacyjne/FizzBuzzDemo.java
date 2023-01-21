package org.example.zadania_rekrutacyjne;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FizzBuzzDemo {
    public static void main(String[] args) {
         Stream.iterate(1, integer -> integer + 1)
                .limit(100)
                .forEach(FizzBuzzDemo::printMessage);
    }

    private static void printMessage(int number) {
        Predicate<Integer> isDividableBy3Predicate = (x) -> x % 3 == 0;
        Predicate<Integer> isDividableBy5Predicate = (x) -> x % 5 == 0;
        Predicate<Integer> isDividableBy3And5Predicate = isDividableBy3Predicate.and(isDividableBy5Predicate);

        boolean by3 = isDividableBy3Predicate.test(number);
        boolean by5 = isDividableBy5Predicate.test(number);
        boolean by3And5 = isDividableBy3And5Predicate.test(number);

        if (by3And5) {
            System.out.println(number + " FizzBuzz");
        } else if (by3) {
            System.out.println(number + " Fizz");
        } else if (by5) {
            System.out.println(number + " Buzz");
        } else {
            System.out.println(number);
        }
    }
}

