package org.telran.parkingproject.dao;

import org.springframework.stereotype.Component;
import org.telran.parkingproject.model.Car;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


@Component
public class CarRepositoryImpl implements CarRepository {

    private List<Car> carList = new ArrayList<>();

    private AtomicInteger carId = new AtomicInteger(5);

    @PostConstruct
    private void init() {
        carList.add(new Car("Lada", 1950, 1, "red"));
        carList.add(new Car("BMW", 1950, 3, "white"));
        carList.add(new Car("VW", 1989, 2, "black"));
        carList.add(new Car("JAVA", 1960, 4, "red"));
//        carList.add(new Car("Mercedes", 2010, 5, "blue"));
//        carList.add(new Car("Mazda", 2005, 6, "green"));
//        carList.add(new Car("KIA", 2000, 7, "black"));
    }

    @Override
    public List<Car> list() {
        return carList;
    }

    @Override
    public Car getCar(int id) {
        return carList.stream().filter(car -> car.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Car save(Car car) {
        car.setId(carId.incrementAndGet());
        carList.add(car);
        return car;
    }

    @Override
    public boolean remove(int id) {
        carList = carList.stream().filter(car -> car.getId() != id).collect(Collectors.toList());
        return true;
    }


}
