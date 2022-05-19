package com.norauto.demo.model;

public enum VehicleStatus {

    BROKEN_DOWN("broken-down"),
    OK("ok");

    private String vehicleStatus;

    VehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}
