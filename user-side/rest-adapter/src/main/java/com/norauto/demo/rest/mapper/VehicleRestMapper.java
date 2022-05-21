package com.norauto.demo.rest.mapper;

import com.norauto.demo.model.Vehicle;
import com.norauto.demo.rest.dto.VehicleResponse;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface VehicleRestMapper {
    List<VehicleResponse> toVehicleResponse(List<Vehicle> vehicle);

    VehicleResponse toVehicleResponse(Vehicle vehicle);

}
