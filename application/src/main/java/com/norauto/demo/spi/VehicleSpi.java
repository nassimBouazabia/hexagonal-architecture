package com.norauto.demo.spi;

import com.norauto.demo.model.Vehicle;

import java.util.List;

public interface VehicleSpi {

    List<Vehicle> getBrokenDownVehicles();

    void updateRepairedVehicles();

    Vehicle createVehicle(Vehicle vehicle);
}
