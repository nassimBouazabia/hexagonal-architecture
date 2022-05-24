package com.norauto.demo.service;

import com.norauto.demo.api.VehicleApi;
import com.norauto.demo.model.Vehicle;
import com.norauto.demo.model.VehicleStatus;
import com.norauto.demo.spi.VehicleSpi;
import com.norauto.demo.spi.WorkshopSpi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class VehicleApiImpl implements VehicleApi {

    WorkshopSpi workshopSpi;
    VehicleSpi vehicleSpi;


    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleSpi.createVehicle(vehicle);
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicleSpi.getAllVehicles();
    }

    @Override
    public Vehicle fixVehicle(UUID vehicleId) {
        Vehicle vehicle = vehicleSpi.getVehicle(vehicleId);
        workshopSpi.fixVehicle(vehicle);
        vehicleSpi.updateVehicle(vehicle);
        return vehicle;
    }
}
