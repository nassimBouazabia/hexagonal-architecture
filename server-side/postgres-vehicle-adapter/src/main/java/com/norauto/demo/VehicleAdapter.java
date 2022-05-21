package com.norauto.demo;

import com.norauto.demo.dao.VehicleRepository;
import com.norauto.demo.entities.VehicleEntity;
import com.norauto.demo.mapper.VehicleMapper;
import com.norauto.demo.model.Vehicle;
import com.norauto.demo.spi.VehicleSpi;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class VehicleAdapter implements VehicleSpi {

    VehicleRepository vehicleRepository;
    VehicleMapper vehicleMapper;

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        VehicleEntity vehicleEntity = vehicleMapper.toVehicleEntity(vehicle);
        vehicleEntity = vehicleRepository.save(vehicleEntity);
        return vehicleMapper.toVehicle(vehicleEntity);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<VehicleEntity> vehicleEntities = vehicleRepository.findAll();
        return vehicleMapper.toVehicles(vehicleEntities);
    }

    @Override
    public Vehicle getVehicle(UUID vehicleId) {
        VehicleEntity vehicleEntity = vehicleRepository.getById(vehicleId);
        return vehicleMapper.toVehicle(vehicleEntity);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        VehicleEntity vehicleEntity = vehicleMapper.toVehicleEntity(vehicle);
        vehicleEntity = vehicleRepository.save(vehicleEntity);
        return vehicleMapper.toVehicle(vehicleEntity);
    }

}
