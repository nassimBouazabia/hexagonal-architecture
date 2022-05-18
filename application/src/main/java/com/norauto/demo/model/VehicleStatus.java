package com.norauto.demo.model;

public enum VehicleStatus {

    BROKEN_DOWN("broke down"),
    IN_GOOD_CONDITION("in good condition");

    private String vehicleStatus;

    VehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}
