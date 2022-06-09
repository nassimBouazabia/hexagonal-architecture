package com.norauto.demo.service;

import com.norauto.demo.api.VehicleApi;
import com.norauto.demo.exception.NotSupportedCountryException;
import com.norauto.demo.model.Vehicle;
import com.norauto.demo.spi.VehiclePort;
import com.norauto.demo.spi.WorkshopPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class VehicleApiImpl implements VehicleApi {

    List<WorkshopPort> workshopPorts;
    VehiclePort vehiclePort;


    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehiclePort.createVehicle(vehicle);
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehiclePort.getAllVehicles();
    }

    @Override
    public Vehicle fixVehicle(UUID vehicleId) {
        Vehicle vehicle = vehiclePort.getVehicle(vehicleId);
        WorkshopPort workshopPort = getWorkshopSpi(vehicle);
        workshopPort.fixVehicle(vehicle);
        vehiclePort.updateVehicle(vehicle);
        return vehicle;
    }

    private WorkshopPort getWorkshopSpi(Vehicle vehicle) {
        Optional<WorkshopPort> workshopSpiOptional = workshopPorts.stream()
                .filter(workshopPort1 -> workshopPort1.worksInCountry(vehicle.getCountryCode()))
                .findFirst();

        if (workshopSpiOptional.isEmpty())
            throw new NotSupportedCountryException(vehicle.getCountryCode());
        return workshopSpiOptional.get();
    }
}
