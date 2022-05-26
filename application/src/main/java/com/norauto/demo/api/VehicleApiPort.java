package com.norauto.demo.api;

import com.norauto.demo.model.Vehicle;

import java.util.List;
import java.util.UUID;

public interface VehicleApiPort {

    Vehicle createVehicle(Vehicle vehicle);
    List<Vehicle> getVehicles();
    Vehicle fixVehicle(UUID vehicleId);

}
