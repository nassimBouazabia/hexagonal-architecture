package com.norauto.demo.workshop;

import com.norauto.demo.model.Vehicle;
import com.norauto.demo.spi.WorkshopPort;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class WorkshopAdapter implements WorkshopPort {

    List<String> supportedCountries = Arrays.asList("FR", "ES", "PT", "IT", "BE");


    @Override
    public Vehicle fixVehicle(Vehicle vehicle) {
        System.out.println("The vehicle is fixed by the workshop: Norauto");
        vehicle.fixVehicle();
        return vehicle;
    }

    @Override
    public boolean worksInCountry(String country) {
        return supportedCountries.contains(country);
    }
}
