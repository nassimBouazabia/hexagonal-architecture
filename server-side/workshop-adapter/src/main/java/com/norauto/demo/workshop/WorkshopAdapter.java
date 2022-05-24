package com.norauto.demo.workshop;

import com.norauto.demo.model.Vehicle;
import com.norauto.demo.spi.WorkshopSpi;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkshopAdapter implements WorkshopSpi {

    @Override
    public void fixVehicle(Vehicle vehicles) {
        vehicles.fixVehicle();
    }
}
