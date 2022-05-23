package com.norauto.demo.spi;

import com.norauto.demo.model.Vehicle;

import java.util.List;

public interface WorkshopSpi {

    Vehicle fixVehicle(Vehicle vehicles);
    boolean worksInCountry(String country);
}
