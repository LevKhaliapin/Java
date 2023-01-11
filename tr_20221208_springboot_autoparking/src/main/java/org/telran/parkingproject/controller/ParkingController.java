package org.telran.parkingproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.parkingproject.model.Car;
import org.telran.parkingproject.service.ParkingService;

import java.util.List;

@RestController
@RequestMapping("/parking")        //      localhost:8080/parking
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @GetMapping
    public List<Car> list() {
        return parkingService.list();
    }

    @PostMapping()
    public boolean add(@RequestBody int carId) {
        return parkingService.addCar(carId);
    }

    @DeleteMapping("/{carId}")
    public boolean remove(@PathVariable(name = "carId") int carId) {
        return parkingService.deleteCar(carId);
    }
}
