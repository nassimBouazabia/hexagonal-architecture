package com.norauto.demo.service;

import com.norauto.demo.api.VehicleApiPort;
import com.norauto.demo.model.Vehicle;
import com.norauto.demo.vehicle.VehicleDAO;
import com.norauto.demo.vehicle.entities.VehicleEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class VehicleApiImpl implements VehicleApiPort {

    VehicleDAO vehicleDAO;

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        VehicleEntity vehicleEntity = vehicle.toVehicleEntity();
        vehicleEntity = vehicleDAO.createVehicle(vehicleEntity);
        return new Vehicle(vehicleEntity);
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
