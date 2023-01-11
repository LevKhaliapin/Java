package org.telran.parkingproject.service;

//CRUD - create, read, update, delete

//1.List all cars
//2.Get one car
//3.Create new cars
//4.Update car
//5.Delete car

import org.telran.parkingproject.model.Car;

import java.util.List;

public interface CarService {

    List<Car> list();

    Car getCar(int id);

    Car save(Car car);

    Car update(Car car);

    boolean delete(int id);

}
