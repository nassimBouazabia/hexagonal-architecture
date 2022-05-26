package com.norauto.demo.vehicle;

import com.norauto.demo.vehicle.dao.VehicleRepository;
import com.norauto.demo.vehicle.entities.VehicleEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class VehicleDAO {

    VehicleRepository vehicleRepository;

    public VehicleEntity createVehicle(VehicleEntity vehicleEntity) {
        return vehicleRepository.save(vehicleEntity);
    }

    public List<VehicleEntity> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public VehicleEntity getVehicle(UUID vehicleId) {
        return vehicleRepository.getById(vehicleId);
    }

    public VehicleEntity updateVehicle(VehicleEntity vehicleEntity) {
        return vehicleRepository.save(vehicleEntity);
    }

}
