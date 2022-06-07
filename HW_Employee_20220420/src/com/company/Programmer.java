package com.company;

public class Programmer extends Employee {
    Employee teamLead;

    public Programmer(String name, double salary, Employee teamLead) {
        super(name, salary);
        this.teamLead = teamLead;
    }

    @Override
    public String toString() {
        return super.toString() + " teamLead:" + teamLead.toString();
    }

    public void doWork() {
        System.out.println("I am a programmer and I write code");
    }
}