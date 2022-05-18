package com.norauto.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Vehicle {

    private String licencePlate;
    private VehicleStatus vehicleStatus;

    public boolean isBrokenDown(){
        return this.vehicleStatus == VehicleStatus.BROKEN_DOWN;
    }

    public Vehicle fixVehicle(){
        this.vehicleStatus = VehicleStatus.IN_GOOD_CONDITION;
        return this;
    }
}
