package com.company;

import java.util.List;

public class Person {
    private String name;
    private int age;
    private List<String> email;
    private String city;

    public Person(String name, int age, List<String> email, String city) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "{" +
                name + ' ' +
                age + ' ' +
                email + ' ' +
                city + '}';
    }
}
