package org.example.functions;

import java.util.function.Function;

public class Functions {
    private Functions() {}

    public final static Function<Integer, Integer> incrementFunction = x -> x + 1;
    public final static Function<Integer, Integer> identiyFunction = Function.identity();
    public final static Function<Integer, Integer> identiyFunction2 = x -> x;
    public final static Function<Integer, Integer> multiplyBy2Function = x -> 2 * x;
//    Functions x = incrementFunction.   czym się różni compose od andThen?
}
