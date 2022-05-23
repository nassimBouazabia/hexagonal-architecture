package com.norauto.demo.workshop;

import com.norauto.demo.model.Vehicle;
import com.norauto.demo.spi.WorkshopSpi;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AtuWorkshopAdapter implements WorkshopSpi {

    List<String> supportedCountries = Arrays.asList("DE", "AU");

    @Override
    public Vehicle fixVehicle(Vehicle vehicle) {
        System.out.println("The vehicle is fixed by the workshop: ATU");
        vehicle.fixVehicle();
        return vehicle;
    }

    @Override
    public boolean worksInCountry(String country) {
        return supportedCountries.contains(country);
    }
}
