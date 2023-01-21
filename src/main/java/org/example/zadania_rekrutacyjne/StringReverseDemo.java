package org.example.zadania_rekrutacyjne;

import java.util.Arrays;

public class StringReverseDemo {

    public static void main(String[] args) {
        String words = "foo bar foobar    one two";
        String wordsReversed = "";
        String table [] = words.split(" ");     // nie wiem dlaczego zadziałało, ale fajnie
        int size = table.length;
        ///////////////////////////////// do zakomentowania
        System.out.println(size);
        System.out.println(Arrays.toString(table));
        ///////////////////////////////// do zakomentowania
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                wordsReversed = wordsReversed.concat(table[size - 1 - i]);   // bo ostatni wyraz nie powinien zawierać spacji
            } else {
                wordsReversed = wordsReversed.concat(table[size - 1 - i].concat(" "));
            }
        }
        System.out.println(wordsReversed);
    }
}
