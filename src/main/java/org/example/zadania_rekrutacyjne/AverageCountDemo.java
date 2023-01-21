package org.example.zadania_rekrutacyjne;

import java.util.Arrays;

public class AverageCountDemo {
    public static void main(String[] args) {
        int table[] = {1, 2, 3};   // nie martw się o nula w tablicy int, bo go nie ma prawa tam być, byłby wtedy błąd komplacji!
        double average = Arrays.stream(table).average().orElse(Integer.MIN_VALUE);
        System.out.println(average);
    }
}
