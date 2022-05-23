package com.norauto.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class Vehicle {

    private UUID id;
    private String licencePlate;
    private VehicleStatus vehicleStatus;
    private String countryCode;

    public boolean isBrokenDown(){
        return this.vehicleStatus == VehicleStatus.BROKEN_DOWN;
    }

    public Vehicle fixVehicle(){
        this.vehicleStatus = VehicleStatus.OK;
        return this;
    }
}
