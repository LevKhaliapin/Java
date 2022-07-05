package com.company;

public interface EmployeeTeamList {
    public void add(Employee e);

    public int size();

    public void increaseSize(int size);

    public Employee get(int index);

    public int find(Employee e);


}
