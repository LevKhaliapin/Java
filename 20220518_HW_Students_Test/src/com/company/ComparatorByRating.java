package com.company;

import java.util.Comparator;

public class ComparatorByRating implements Comparator<Student> {
    @Override
    public int compare(Student st1, Student st2) {
        return (int) st1.getRating() - (int) st2.getRating();
    }
}
