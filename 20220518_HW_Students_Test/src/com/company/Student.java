package com.company;

public class Student {
    private String name;
    private double rating;
    private int numOfMissedClasses;

    public Student(String name, double rating, int numberOfMissedClasses) {
        this.name = name;
        this.rating = rating;
        this.numOfMissedClasses = numberOfMissedClasses;
    }

    @Override
    public String toString() {
        return "name = '" + name + '\'' +
                ", rating = " + rating +
                ", numberOfMissedClasses = " + numOfMissedClasses + "\n";
    }


    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getNumOfMissedClasses() {
        return numOfMissedClasses;
    }

}
