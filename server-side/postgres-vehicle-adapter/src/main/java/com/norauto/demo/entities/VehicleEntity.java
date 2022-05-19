package com.norauto.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class VehicleEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String licencePlate;

    private VehicleStatusEntity vehicleStatus;
}

