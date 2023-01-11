package org.telran.parkingproject.service;

//1.List cars parking
//2.Add new car
//3.Delete car

import org.telran.parkingproject.model.Car;

import java.util.List;

public interface ParkingService {

    List<Car> list();

    Car getCar(int carId);

    boolean addCar(int carId);

    boolean deleteCar(int carId);

}
