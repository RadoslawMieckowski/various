package org.example.mains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysMethodsDemo {
    public static void main(String[] args) {

        int table[] = {1,2,3};
        Integer[] integers = Arrays.stream(table).boxed().toArray(Integer[]::new);

        List<Integer> modyfiableList = Arrays.asList(integers);// modifiable list, but fixed size!
//        modyfiableList.add(1); UnsupportedOperationException

        modyfiableList.set(0, 2);// ok, zmieni też integers array!!!
        System.out.println(Arrays.toString(integers));

        List<Integer> fullModyfiableList = new ArrayList<>(List.of(integers));//w pełni niezależna lista!!!

        fullModyfiableList.add(1);
        System.out.println(fullModyfiableList);
        integers[0] = 1; // zmieni też modyfiableList!!!
        System.out.println(modyfiableList);
        System.out.println(fullModyfiableList);



        List<Integer> unmodyfiableList =  Collections.unmodifiableList(Arrays.asList(integers)); // Collections.unmodi... daje różne kolekcje niemodyfikowalnych kolekcji
//        unmodyfiableList.set(0, 2);  UnsupportedOperationException

        List<Integer> unmodyfiableList2 = List.of(integers);
//        unmodyfiableList2.set(0, 2);  UnsupportedOperationException

        System.out.println(integers.getClass().getSimpleName());

        int tableCopy[] = Arrays.copyOf(table,table.length);
        tableCopy[0] = 9;   // w pełni niezależna tablica
        System.out.println(Arrays.toString(table));
    }
}
