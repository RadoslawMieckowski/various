package org.example.zadania_rekrutacyjne;

import java.util.HashMap;
import java.util.Map;

public class TelephoneKeyboardDemo {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>(26);
        initMap(map);
        String numericalCode = getCodeFor("KOT", map);
        System.out.println(numericalCode);
    }

    private static String getCodeFor(String input, Map<String, String> map) {
        String numeicalCode = "";
        for (int i = 0; i < input.length(); i++) {
            char letters = input.charAt(i);
            numeicalCode = numeicalCode.concat(map.get(String.valueOf(letters)));
        }
        return numeicalCode;
    }

    private static void initMap(Map<String, String> map) {
        map.put("A", "2");
        map.put("B", "22");
        map.put("C", "222");
        map.put("D", "3");
        map.put("E", "33");
        map.put("F", "333");
        map.put("G", "4");
        map.put("H", "44");
        map.put("I", "4444");
        map.put("J", "5");
        map.put("K", "55");
        map.put("L", "555");
        map.put("M", "6");
        map.put("N", "66");
        map.put("O", "666");
        map.put("P", "7");
        map.put("Q", "77");
        map.put("R", "777");
        map.put("S", "7777");
        map.put("T", "8");
        map.put("U", "88");
        map.put("V", "888");
        map.put("W", "9");
        map.put("X", "99");
        map.put("Y", "999");
        map.put("Z", "9999");
    }
}
