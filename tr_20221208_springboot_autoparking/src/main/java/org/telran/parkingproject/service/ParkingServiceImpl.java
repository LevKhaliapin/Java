package org.telran.parkingproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.parkingproject.dao.ParkingRepository;
import org.telran.parkingproject.model.Car;

import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    @Override
    public List<Car> list() {
        return parkingRepository.list();
    }

    @Override
    public Car getCar(int carId) {
        return parkingRepository.getCar(carId);
    }

    @Override
    public boolean addCar(int carId) {
        return parkingRepository.addCar(carId);
    }

    @Override
    public boolean deleteCar(int carId) {
        return parkingRepository.deleteCar(carId);
    }
}
