//package com.norauto.demo.vehicle;
//
//import com.norauto.demo.model.Vehicle;
//import com.norauto.demo.vehicle.dao.VehicleRepository;
//import com.norauto.demo.vehicle.entities.VehicleEntity;
//import com.norauto.demo.vehicle.mapper.VehicleMapper;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.UUID;
//
//@Component
//@AllArgsConstructor
//public class VehicleAdapter implements VehicleSpiPort{
//
//    VehicleRepository vehicleRepository;
//    VehicleMapper vehicleMapper;
//
//    public Vehicle createVehicle(Vehicle vehicle) {
//        VehicleEntity vehicleEntity = vehicleMapper.toVehicleEntity(vehicle);
//        vehicleEntity = vehicleRepository.save(vehicleEntity);
//        return vehicleMapper.toVehicle(vehicleEntity);
//    }
//
//    public List<Vehicle> getAllVehicles() {
//        List<VehicleEntity> vehicleEntities = vehicleRepository.findAll();
//        return vehicleMapper.toVehicles(vehicleEntities);
//    }
//
//    public Vehicle getVehicle(UUID vehicleId) {
//        VehicleEntity vehicleEntity = vehicleRepository.getById(vehicleId);
//        return vehicleMapper.toVehicle(vehicleEntity);
//    }
//
//    public Vehicle updateVehicle(Vehicle vehicle) {
//        VehicleEntity vehicleEntity = vehicleMapper.toVehicleEntity(vehicle);
//        vehicleEntity = vehicleRepository.save(vehicleEntity);
//        return vehicleMapper.toVehicle(vehicleEntity);
//    }
//
//}
