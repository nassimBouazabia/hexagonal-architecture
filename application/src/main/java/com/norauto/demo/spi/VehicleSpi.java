package com.norauto.demo.spi;

import com.norauto.demo.model.Vehicle;

import java.util.List;
import java.util.UUID;

public interface VehicleSpi {

    Vehicle createVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
    Vehicle getVehicle(UUID vehicleId);
    Vehicle updateVehicle(Vehicle vehicle);

}
