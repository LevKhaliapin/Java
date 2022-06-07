package com.company;

public class Intern extends Employee {

    public Intern(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void doWork() {
        System.out.println("It's intern");
    }
}
