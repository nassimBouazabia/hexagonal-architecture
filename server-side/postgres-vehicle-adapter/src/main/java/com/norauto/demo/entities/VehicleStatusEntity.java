package com.norauto.demo.entities;

public enum VehicleStatusEntity {

    BROKEN_DOWN("broken-down"),
    OK("ok");

    private String vehicleStatus;

    VehicleStatusEntity(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}