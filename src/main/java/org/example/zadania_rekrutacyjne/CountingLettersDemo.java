package org.example.zadania_rekrutacyjne;

import java.util.HashMap;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class CountingLettersDemo {
    static String input = "To jest mój miodziuś.!?";
    public static void main(String[] args) {
        IntPredicate isNotDot = x -> x != '.';
        IntPredicate isNotExclamation = x -> x != '!';
        IntPredicate isNotQuestion = x -> x != '?';
        IntPredicate isNotSpace = x -> x != ' ';

        IntPredicate punctuationPredicate = isNotDot.and(isNotQuestion)
                        .and(isNotExclamation)
                        .and(isNotSpace);

        Set<Character> keys = input.chars()
                .filter(punctuationPredicate)
                .mapToObj(letter ->
                        Character.valueOf((char) letter))
                .collect(Collectors.toSet());

        System.out.println(keys);
        HashMap<Character, Long> mapOfLetters = new HashMap<>();
        long counter;
        for (Character key : keys) {
            counter = input.chars()
                    .filter(letter -> letter == key.charValue())
                    .count();
            mapOfLetters.put(key, counter);
        }
        System.out.println(mapOfLetters);
    }
}
