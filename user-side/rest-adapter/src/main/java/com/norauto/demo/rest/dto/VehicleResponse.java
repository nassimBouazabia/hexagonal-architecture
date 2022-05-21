package com.norauto.demo.rest.dto;

import com.norauto.demo.model.VehicleStatus;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Data
public class VehicleResponse extends RepresentationModel<VehicleResponse> {
    private UUID id;
    private String licencePlate;
    private VehicleStatus vehicleStatus;
}
