package org.example.mains;

import org.example.consumers.Consumers;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static org.example.beans.utils.ListParser.*;
import static org.example.functions.Functions.incrementFunction;
import static org.example.predicates.Predicates.isEvenAndGreaterThan4;

public class StreamsDemo {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> oddList = List.of(1, 3, 5, 7);
        List<Integer> evenList = List.of(0, 2, 4, 6, 8);

        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(integerList);
        listOfLists.add(oddList);
        listOfLists.add(evenList);
//        System.out.println(listOfLists);

        List<Integer> flattenAndTransformedList = flattenAndTransform(listOfLists, incrementFunction);

        List<Integer> flattenList = flattenList(listOfLists);

        List<Integer> flattenAndFilteredList = flattenAndFilterList(listOfLists, isEvenAndGreaterThan4);

        List<Integer> flattenAndDistinctList = flattenAndDistictAndSortedList(listOfLists);

        List<Integer> flattenAndDistinctAndSortedWithLimitList = flattenAndDistinctAndSortedWithLimit(listOfLists, 4);


        int min = getMin(integerList);

        int max = getMax(integerList);

        double avg = getAvg(integerList);

        int sum = getSum(integerList);

        System.out.println(flattenList);
        System.out.println(flattenAndTransformedList);
        System.out.println(flattenAndFilteredList);
        System.out.println(flattenAndDistinctList);
        System.out.println(min);
        System.out.println(max);
        System.out.println(avg);
        System.out.println(sum);
        System.out.println(flattenAndDistinctAndSortedWithLimitList);

        /*for (List<Integer> list : listOfLists) {        // I sposób
            Consumers.printListOfListsConsumer.accept(list);
        }

        listOfLists.forEach(Consumers.printListOfListsConsumer);// II sposób*/

        List<Integer> peekFlatList = listOfLists.stream()// III sposób
                .peek(Consumers.printListOfListsConsumer)//tu nie tylko wyświetlamy na konsoli, ale działamy też dalej
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());//terminal operation inicjuje pracę pipeline'a

        System.out.println(peekFlatList);

        DoubleSummaryStatistics statistics = getDoubleSummaryStatistics(integerList); //statystyka, zaoszczędza pisania 5 pipelinów

        System.out.println(statistics);

        Supplier<List<Integer>> evenListSupplier = () -> evenList;
        List<Integer> copyEvenList = new ArrayList<>(evenListSupplier.get());
    }
}
