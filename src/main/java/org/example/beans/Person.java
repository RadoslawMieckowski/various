package org.example.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    private String name;
    private int age;
    private String country;
    private int id;
    private double salary;
    private Set<Beverage> beverages;

    public Person(String country) {
        this.country = country;
    }
}
