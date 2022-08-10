package com.company;

import java.util.List;

public class Company {

    private String title;
    private List<Person> employee;

    public Company(String title, List<Person> employee) {
        this.title = title;
        this.employee = employee;
    }

    public String getTitle() {
        return title;
    }

    public List<Person> getEmployee() {
        return employee;
    }

    @Override
    public String toString() {
        return "(" +
                title + ' ' +
                employee +
                ')';
    }
}
