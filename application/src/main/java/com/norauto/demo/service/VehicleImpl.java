package com.norauto.demo.service;

import com.norauto.demo.api.VehicleApi;
import com.norauto.demo.model.Vehicle;
import org.springframework.stereotype.Component;

import java.beans.JavaBean;
import java.util.List;

@Component
public class VehicleImpl implements VehicleApi {

    @Override
    public List<Vehicle> getVehiclesToRepair() {
        return List.of(new Vehicle("12345"));
    }
}
