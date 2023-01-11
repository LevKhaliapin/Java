package org.telran.parkingproject.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telran.parkingproject.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingRepositoryImpl implements ParkingRepository {

    private List<Car> parkingList = new ArrayList<>();

    @Autowired
    private CarRepository carRepository;


    @Override
    public List<Car> list() {
        return parkingList;
    }

    @Override
    public Car getCar(int carId) {
        return parkingList.stream().filter(car -> car.getId() == carId).findFirst().orElse(null);
    }

    @Override
    public boolean addCar(int carId) {
        if (carRepository.getCar(carId) == null || getCar(carId) != null) return false;
        return parkingList.add(carRepository.getCar(carId));
    }

    @Override
    public boolean deleteCar(int carId) {
        if (getCar(carId) == null) return false;
        parkingList = parkingList.stream()
                .filter(car -> car.getId() != carId)
                .collect(Collectors.toList());
        return true;
    }

}
