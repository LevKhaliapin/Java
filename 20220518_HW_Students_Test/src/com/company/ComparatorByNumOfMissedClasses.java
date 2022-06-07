package com.company;

import java.util.Comparator;

public class ComparatorByNumOfMissedClasses implements Comparator<Student> {
    @Override
    public int compare(Student st1, Student st2) {
        return st1.getNumOfMissedClasses() - st2.getNumOfMissedClasses();
    }
}
