package org.example.zadania_rekrutacyjne;

import java.util.Arrays;

public class SortingWithStreamsDemo {
    public static void main(String[] args) {
        int table[] = {-5, 2, 0, 1, 4, 2, -10, 6};

        long begin1 = System.nanoTime();
        Integer tableOfIntegers[] = Arrays.stream(table)
                .sorted()
                .boxed()
                .toArray(Integer[]::new);
        long end1 = System.nanoTime();
        long time1 = end1 - begin1;

        long begin2 = System.nanoTime();
        Arrays.parallelSort(table);
        long end2 = System.nanoTime();
        long time2 = end2 - begin2;

        System.out.println("time of streamAPI: " + time1);
        System.out.println(Arrays.toString(table));

        System.out.println("time of parallerSort from Arrays' API: " + time2);
        System.out.println(Arrays.toString(tableOfIntegers));
        //dowiedz się czy sortowanie w streamie jest szybsze od zwykłego. odp: jest, a parallerSort jeszcze szybsze, bowykorzystuje kilkardzeni procesora(kilka wątków)
    }
}
