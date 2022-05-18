package com.norauto.demo.api;

import com.norauto.demo.model.Vehicle;

import java.util.List;

public interface VehicleApi {

    List<Vehicle> getVehiclesToRepair();

    List<Vehicle> repairVehicles();
}
