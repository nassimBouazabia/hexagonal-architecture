package com.norauto.demo.rest;

import com.norauto.demo.api.VehicleApi;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class MyRestController {

    VehicleApi vehicleApi;

    @GetMapping("/hello")
    public String hello() {
        return vehicleApi.getVehiclesToRepair().get(0).toString();
    }
}
