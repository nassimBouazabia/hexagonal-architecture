package com.norauto.demo.rest.controller;

import com.norauto.demo.api.VehicleApi;
import com.norauto.demo.model.Vehicle;
import com.norauto.demo.rest.dto.VehicleResponse;
import com.norauto.demo.rest.mapper.VehicleRestMapper;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.UriTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor
public class VehicleController {

    VehicleApi vehicleApi;
    VehicleRestMapper vehicleRestMapper;

    @PostMapping
    public ResponseEntity<VehicleResponse> createVehicle(@RequestBody Vehicle vehicleCreationRequest) {
        Vehicle vehicle = vehicleApi.createVehicle(vehicleCreationRequest);
        VehicleResponse vehicleResponse = vehicleRestMapper.toVehicleResponse(vehicle);
        return ResponseEntity.of(Optional.of(vehicleResponse));
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponse>> getVehicles() {
        List<Vehicle> vehicles = vehicleApi.getVehicles();

        List<VehicleResponse> vehicleResponses = new ArrayList<>();
        vehicles.stream().forEach(vehicle -> {
                            VehicleResponse vehicleResponse = vehicleRestMapper.toVehicleResponse(vehicle);
                            if (vehicle.isBrokenDown()) {
                                vehicleResponse.add(
                                        Link.of(UriTemplate.of("localhost:8080/vehicles/" + vehicleResponse.getId() + "/fix"), "fixVehicle")
                                );
                            }
                            vehicleResponses.add(vehicleResponse);
                        }
                );
        return ResponseEntity.of(Optional.of(vehicleResponses));
    }

    @PostMapping("/{vehicleId}/fix")
    public ResponseEntity<VehicleResponse> fixVehicle(@PathVariable UUID vehicleId) {
        Vehicle vehicle = vehicleApi.fixVehicle(vehicleId);
        VehicleResponse vehicleResponse = vehicleRestMapper.toVehicleResponse(vehicle);
        return ResponseEntity.of(Optional.of(vehicleResponse));
    }

}
