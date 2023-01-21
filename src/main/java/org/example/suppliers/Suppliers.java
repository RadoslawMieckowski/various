package org.example.suppliers;

import org.example.beans.Person;

import java.util.function.Supplier;

public class Suppliers {
    private Suppliers() {}

    Supplier<Person> personSupplier = () -> new Person("Poland");
}
