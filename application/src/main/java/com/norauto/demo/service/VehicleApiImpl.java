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
    public List<Vehicle> getVehiclesToRepair() {
        List<Vehicle> vehicles = List.of(new Vehicle(UUID.randomUUID(),"12345", VehicleStatus.BROKEN_DOWN));
        workshopSpi.repairVehicles(vehicles);
        return vehicles;
    }

    @Override
    public List<Vehicle> repairVehicles() {
        Vehicle vehicle1 = new Vehicle(UUID.randomUUID(),"12345", VehicleStatus.BROKEN_DOWN);
        Vehicle vehicle2 = new Vehicle(UUID.randomUUID(),"54321", VehicleStatus.OK);

        List<Vehicle> vehicles = List.of(vehicle1,vehicle2);
        workshopSpi.repairVehicles(vehicles);
        return vehicles;
    }
}
