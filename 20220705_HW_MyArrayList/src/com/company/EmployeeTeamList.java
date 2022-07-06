package com.company;

public interface EmployeeTeamList<T> {
    public void add(T e);

    public int size();

    public void increaseSize(int size);

    public T get(int index);

    public int find(T e);


}
