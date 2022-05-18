package com.norauto.demo.service;

import com.norauto.demo.api.VehicleApi;
import com.norauto.demo.model.Vehicle;
import com.norauto.demo.model.VehicleStatus;
import com.norauto.demo.spi.WorkshopSpi;
import lombok.AllArgsConstructor;

import java.util.List;

//@Component
@AllArgsConstructor
public class VehicleImpl implements VehicleApi {

    WorkshopSpi workshopSpi;

    @Override
    public List<Vehicle> getVehiclesToRepair() {
        List<Vehicle> vehicles = List.of(new Vehicle("12345", VehicleStatus.BROKEN_DOWN));
        workshopSpi.repairVehicles(vehicles);
        return vehicles;
    }

    @Override
    public List<Vehicle> repairVehicles() {
        Vehicle vehicle1 = new Vehicle("12345", VehicleStatus.BROKEN_DOWN);
        Vehicle vehicle2 = new Vehicle("54321", VehicleStatus.IN_GOOD_CONDITION);

        List<Vehicle> vehicles = List.of(vehicle1,vehicle2);
        workshopSpi.repairVehicles(vehicles);
        return vehicles;
    }
}
