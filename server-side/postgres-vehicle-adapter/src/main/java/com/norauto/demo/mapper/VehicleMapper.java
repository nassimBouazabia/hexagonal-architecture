package com.norauto.demo.mapper;

import com.norauto.demo.entities.VehicleEntity;
import com.norauto.demo.model.Vehicle;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface VehicleMapper {

    VehicleEntity toVehicleEntity(Vehicle vehicle);
    Vehicle toVehicle(VehicleEntity vehicleEntity);

}
