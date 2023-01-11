package org.telran.parkingproject.model;

import java.util.List;

public class Parking {

    private List<Car> parkingList;

    public Parking(){
       //
    }

    public List<Car> getParkingList() {
        return parkingList;
    }

    public void setParkingList(List<Car> parkingList) {
        this.parkingList = parkingList;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "parkingList=" + parkingList +
                '}';
    }
}
