package org.example.predicates;

import java.util.function.Predicate;

public class Predicates {
    private Predicates(){}

    public static final Predicate<Integer> isEven = x -> x % 2 == 0;
    public static final Predicate<Integer> isGreaterThan4 = x -> x > 4;
    public static final Predicate<Integer> isEvenAndGreaterThan4 = isEven.and(isGreaterThan4);
    public static final Predicate<Integer> isnotEvenAndIsGreaterThan4 = isEven.negate().and(isGreaterThan4);
    public static final Predicate<Integer> isnotEvenAndIsNotGreaterThan4 = isEven.negate().and(isGreaterThan4).negate();
    public static final Predicate<Integer> getIsEvenOrIsGreaterThan4 = isEven.or(isGreaterThan4);
}
