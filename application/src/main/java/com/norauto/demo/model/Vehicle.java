package com.norauto.demo.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Vehicle {

    private String licencePlate;

    public String toString(){
        return licencePlate;
    }

}
