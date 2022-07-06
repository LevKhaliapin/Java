package com.company;

import java.util.Arrays;

public class EmployeeTeam <T> implements EmployeeTeamList<T> {
    private int capacity = 3;
    private int currentIndex = 0;
    Object[] team = new Object[capacity];


    @Override
    public void add(T e) {
        if (currentIndex==capacity){
            increaseSize(capacity*2);
        }
        team[currentIndex++] = (T) e;
    }

    @Override
    public int size() {
        return currentIndex;
    }

    @Override
    public void increaseSize(int size) {
        if (size > capacity) {
            Object[] temp = new Object[size];
            for (int i = 0; i < team.length; i++) {
                temp[i] = team[i];
            }
            capacity = size;
            team = temp;
        }
    }

    @Override
    public T get(int index) {
        if (index>=size()) {
            System.out.println("Элемент с указанным индексом не существует");
            return null;
        } else {
            return (T) team[index];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeTeam)) return false;

        EmployeeTeam that = (EmployeeTeam) o;

        if (capacity != that.capacity) return false;
        if (currentIndex != that.currentIndex) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(team, that.team);
    }

    @Override
    public int hashCode() {
        int result = capacity;
        result = 31 * result + currentIndex;
        result = 31 * result + Arrays.hashCode(team);
        return result;
    }

    public int find(T e) {
        for (int i = 0; i < team.length; i++) {
            if(team[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "EmployeeTeam{" +
                "capacity=" + capacity +
                ", currentIndex=" + currentIndex +
                ", team=" + Arrays.toString(team) +
                '}';
    }
}
