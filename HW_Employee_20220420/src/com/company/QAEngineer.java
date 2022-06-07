package com.company;

public class QAEngineer extends Employee {

    public QAEngineer(String name, double salary) {
        super(name, salary);
    }

    public void doWork() {
        System.out.println("I am a QAEngineer and I check the programs");
    }

}