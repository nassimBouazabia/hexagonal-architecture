package com.norauto.demo.service;

import com.norauto.demo.api.VehicleApi;
import com.norauto.demo.model.Vehicle;
import com.norauto.demo.vehicle.VehicleDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class VehicleApiImpl implements VehicleApi {

//    WorkshopAdapter workshopSpi;
//    VehicleAdapter vehicleSpi;
    VehicleDAO vehicleDAO;

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return new Vehicle(vehicleDAO.createVehicle(vehicle.toVehicleEntity()));
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicleDAO.getAllVehicles().stream()
                .map(vehicleEntity -> new Vehicle(vehicleEntity))
                .toList();
    }

    @Override
    public Vehicle fixVehicle(UUID vehicleId) {
        Vehicle vehicle = new Vehicle(vehicleDAO.getVehicle(vehicleId));
        vehicle.fixVehicle();
        vehicleDAO.updateVehicle(vehicle.toVehicleEntity());
        return vehicle;
    }
}
