package com.company;

public class Performer {
    private String name;
    private String city;
    private Task task;

    public Performer(String name, String city, Task task) {
        this.name = name;
        this.city = city;
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Task getTask() {
        return task;
    }

    @Override
    public String toString() {
        return name + ' '
                + city + ' '
                + task;
    }
}
