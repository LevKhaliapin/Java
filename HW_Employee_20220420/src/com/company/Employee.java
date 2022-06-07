package com.company;

public abstract class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract void doWork();

    public void paySalary() {
        System.out.println(name + " get " + salary);
    }

    @Override
    public String toString() {
        return name + " (" + salary + ')';
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
