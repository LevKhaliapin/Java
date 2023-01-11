package org.telran.parkingproject.dao;

import org.telran.parkingproject.model.Car;

import java.util.List;

public interface CarRepository {

    List<Car> list();

    Car getCar(int id);

    Car save(Car car);

    boolean remove(int id);
}
