package org.telran.parkingproject.dao;

import org.telran.parkingproject.model.Car;

import java.util.List;

public interface ParkingRepository {

    List<Car> list();

    Car getCar(int carId);

    boolean addCar(int carId);

    boolean deleteCar(int carId);

}
