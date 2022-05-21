package com.norauto.demo.rest.controller;

import com.norauto.demo.api.VehicleApi;
import com.norauto.demo.model.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor
public class VehicleController {

    VehicleApi vehicleApi;

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicleCreationRequest){
        Vehicle vehicle = vehicleApi.createVehicle(vehicleCreationRequest);
        return ResponseEntity.of(Optional.of(vehicle));
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getVehicles(){
        List<Vehicle> vehicles = vehicleApi.getVehicles();
        return ResponseEntity.of(Optional.of(vehicles));
    }

    @PostMapping("/{vehicleId}/fix")
    public ResponseEntity<Vehicle> fixVehicle(@PathVariable UUID vehicleId){
        Vehicle vehicle = vehicleApi.fixVehicle(vehicleId);
        return ResponseEntity.of(Optional.of(vehicle));
    }



}
