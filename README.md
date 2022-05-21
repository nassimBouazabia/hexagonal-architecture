# Hexagonal architecture example
This project contains an example of the Hexagonal architecture with a Spring-boot implementation.
You can follow the step below and have an experience that help you to understand and to start using this architecture.

## Project structure  
```
____ bootloader: project starter 
|
|____ application: modules that containes business APIs, SPIs (Service provider interfaces) and implementations
|
|____ server-side: directory that helps the project orranisation and allows to put server side modules together
|  |
|  |____ rest-adapter: modules where the rest API is defined
|  |
|  |____ postgres-vehicle-adapter: database implementation for managing vehicles
|
|____ user-side: directory that helps the project orranisation and allows to put user side modules together
|  |
|  |____ rest-adapter: rest implementation to exposr the business APIs
|
|____ pom.xml: parent pom of all submodules for dependency management
|
|____ Dockerfile: for building the docker image
|
|____ docker-compose: allows to startup the project quicly (note that the java build is not triggred with)
```


# Demo  
## Rest layer 

On the following example, we will see how does the hexagonal architecture allows to modify the presentation of your services without having any impact on the applixation layer and on your business layer.
With the standard implementation, if you request for a list of vehicles, you get each vehicle on the following format:
```json
{
    "id": "0cc8c6ca-893a-4ef1-a989-41ba2d5e9f68",
    "licencePlate": "12345",
    "vehicleStatus": "OK",
    "brokenDown": false
}
```
The standard vehicle object is as follow
```java
    private UUID id;
    private String licencePlate;
    private VehicleStatus vehicleStatus;
```
We can see that the `"brokenDown": false"` appears because the field name respects the naming convention of a boolean getter.
For a rest API, we would prefer to respect the REST standard instead of java one and we dont want to get this field that can be redundant with the `vehicleStatus` (let's assume that we don't want that).  
The goal in what follows is to use **hateoas** when answering to the front to tell if a vehicle can be fixed.  

### 1 - Stop using the domain object on the rest API

Create a `VehicleResponse` class to return a specific object from the rest controller and to stop using the one of the domain:
````java
package com.norauto.demo.rest.dto;

import com.norauto.demo.model.VehicleStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class VehicleResponse {
    private UUID id;
    private String licencePlate;
    private VehicleStatus vehicleStatus;
}
````
Create a mapper to return the `VehicleResponse` when getting a list of vehicles. To do that, we will add `mapstruct` dependencies to the `pom.xml` of the rest layer
```xml
        <dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct-processor</artifactId>
        </dependency>
```
Then create the mapper from `Vehicle` to `VehicleResponse`
````java
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
````

Then last step, return `List<VehicleResponse>` instead of `Vehicle` with changing the `getVehicles()` method in the class `VehicleController`

```java
    VehicleRestMapper vehicleRestMapper;

    @GetMapping
    public ResponseEntity<List<VehicleResponse>> getVehicles(){
        List<Vehicle> vehicles = vehicleApi.getVehicles();
        List<VehicleResponse> vehicleResponses = vehicleRestMapper.toVehicleResponse(vehicles);
        return ResponseEntity.of(Optional.of(vehicleResponses));
    }
```
Then if you get from now the list of existing vehicles, tou will get them as follows
```json
[
    {
        "id": "6c06d88d-6ed7-4c50-86c2-a6c690054e93",
        "licencePlate": "12345",
        "vehicleStatus": "BROKEN_DOWN"
    }
]
```
You can see than we don't have anymore the `"brokenDown"` field.

### 2. Add hateoas implementation

 Add to the rest layer `pom.xml` the hateoas dependency
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-hateoas</artifactId>
        </dependency>
```

Modify the getVehicles method  in your controller as follow and you should have a first implementation of hateoas on your Rest API without any modification on your rest layer

```java
import com.norauto.demo.rest.dto.VehicleResponse;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.UriTemplate;

import java.util.ArrayList;

    @GetMapping
    public ResponseEntity<List<VehicleResponse>> getVehicles() {
        List<Vehicle> vehicles = vehicleApi.getVehicles();

        List<VehicleResponse> vehicleResponses = new ArrayList<>();
        vehicles.stream().forEach(vehicle -> {
                            VehicleResponse vehicleResponse = vehicleRestMapper.toVehicleResponse(vehicle);
                            if (vehicle.isBrokenDown()) {
                                vehicleResponse.add(
                                        Link.of(UriTemplate.of("localhost:8080/vehicles/" + vehicleResponse.getId() + "/fix"), "fixVehicle")
                                );
                            }
                            vehicleResponses.add(vehicleResponse);
                        }
                );
        return ResponseEntity.of(Optional.of(vehicleResponses));
    }

```
You should from now get the link to fix each broken-down vehicle without any line of code outside of the rest layer