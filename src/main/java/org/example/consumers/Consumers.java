package org.example.consumers;

import java.util.List;
import java.util.function.Consumer;

public class Consumers {
    private Consumers() {}

    public static Consumer<List<Integer>> printListOfListsConsumer = (List<Integer> list) -> System.out.println(list);
}
