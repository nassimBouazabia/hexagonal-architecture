package com.norauto.demo.spi;

import com.norauto.demo.model.Vehicle;

import java.util.List;

public interface WorkshopSpi {

    void fixVehicles(List<Vehicle> vehicles);
    void fixVehicle(Vehicle vehicles);
}
