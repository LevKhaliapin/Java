package org.telran.parkingproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.parkingproject.dao.CarRepository;
import org.telran.parkingproject.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> list() {
        return carRepository.list();
    }

    @Override
    public Car getCar(int id) {
        return carRepository.getCar(id);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car update(Car car) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return carRepository.remove(id);
    }
}
