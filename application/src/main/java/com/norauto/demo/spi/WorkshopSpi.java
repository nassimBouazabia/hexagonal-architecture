package com.norauto.demo.spi;

import com.norauto.demo.model.Vehicle;

import java.util.List;

public interface WorkshopSpi {

    void repairVehicles(List<Vehicle> vehicles);

}
