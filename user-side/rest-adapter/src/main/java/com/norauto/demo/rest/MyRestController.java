package com.norauto.demo.rest;

import com.norauto.demo.api.VehicleApi;
import com.norauto.demo.model.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class MyRestController {

    VehicleApi vehicleApi;

    @GetMapping("/repair")
    public List<Vehicle> hello() {
        return vehicleApi.repairVehicles();
    }

}
