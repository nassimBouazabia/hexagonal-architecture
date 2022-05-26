package com.norauto.demo.model;

import com.norauto.demo.vehicle.entities.VehicleEntity;
import com.norauto.demo.vehicle.entities.VehicleStatusEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class Vehicle {

    private UUID id;
    private String licencePlate;
    private VehicleStatus vehicleStatus;

    public boolean isBrokenDown(){
        return this.vehicleStatus == VehicleStatus.BROKEN_DOWN;
    }

    public Vehicle fixVehicle(){
        this.vehicleStatus = VehicleStatus.OK;
        return this;
    }

    public Vehicle(VehicleEntity vehicleEntity){
        this.id = vehicleEntity.getId();
        this.vehicleStatus = vehicleEntity.getVehicleStatus().equals(VehicleStatusEntity.OK)?VehicleStatus.OK:VehicleStatus.BROKEN_DOWN;
        this.licencePlate = vehicleEntity.getLicencePlate();
    }

    public VehicleEntity toVehicleEntity(){
        VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.setId(this.getId());
        vehicleEntity.setVehicleStatus(
                this.getVehicleStatus().equals(VehicleStatus.OK)?VehicleStatusEntity.OK:VehicleStatusEntity.BROKEN_DOWN
        );
        vehicleEntity.setLicencePlate(this.licencePlate);
        return vehicleEntity;
    }

}
