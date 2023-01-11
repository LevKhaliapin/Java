package org.telran.parkingproject.model;

public class Car {

    private String name;

    private int year;

    private int id;

    private String color;

    public Car() {
        //
    }

    public Car(String name, int year, int id, String color) {
        this.name = name;
        this.year = year;
        this.id = id;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
