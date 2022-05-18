package com.norauto.demo;

import com.norauto.demo.model.Vehicle;
import com.norauto.demo.spi.WorkshopSpi;

import java.util.List;

//@Component
public class WorkshopAdapter implements WorkshopSpi {

    @Override
    public void repairVehicles(List<Vehicle> vehicles) {
        vehicles.stream()
                .filter(vehicle -> vehicle.isBrokenDown())
                .map(vehicle -> vehicle.fixVehicle())
                .toList();
    }
}
