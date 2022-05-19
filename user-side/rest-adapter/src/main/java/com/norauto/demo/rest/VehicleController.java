package com.norauto.demo.rest;

import com.norauto.demo.api.VehicleApi;
import com.norauto.demo.model.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@AllArgsConstructor
public class VehicleController {

    VehicleApi vehicleApi;

    @PostMapping("/vehicles")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicleCreationRequest){
        Vehicle vehicle = vehicleApi.createVehicle(vehicleCreationRequest);
        return ResponseEntity.of(Optional.of(vehicle));
    }

    @GetMapping("/repair")
    public List<Vehicle> hello() {
        return vehicleApi.repairVehicles();
    }

}
