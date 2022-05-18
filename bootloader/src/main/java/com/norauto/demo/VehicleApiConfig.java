package com.norauto.demo;

import com.norauto.demo.api.VehicleApi;
import com.norauto.demo.service.VehicleImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehicleApiConfig {

    @Bean
    VehicleApi vehicleApi(){
        return new VehicleImpl(new WorkshopAdapter());
    }

}
