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

## Demo:

### IOC
The `main` branch is used to demonstrate how IOC (inversion of controle) works and how to switch from an "n layers" architecture to an Hexagonal architecture.

* You can run 'docker-compose up', startup the project with the profile `-Dspring.profiles.active=dev` and test the api calls
* DAO Objects are visible from the controller and from the application module
* Change the dependencies as follow rest -> application <- postgres adapter
* Remove mappers from and to the VehicleEntity from the Vehicle Object
* Remove the entities from the application layer
* Inject the SPIs that are defined in the spi package into the service implementation
* Uncomment the mapper in the postgres adapter
* You can notice that the postgres adapters Objecs are not visible anymore from the rest layer
* You can notice that the application layer doesn't know neither rest layer's objects nor postgres ones
* Run the application again and use the same requests, you should get the same results

Congratulations! you've well switched from an "n layers architecture" to a Hexagonal architecture


### Multiple implementations
The `multipleImplementations` branch contains the demo to see how can we use multiple implementations for the same port.
* Notice in the application layer that a piece of code have been added to deal with multiple implementations fitting to the need
* You can run the demo and save vehicles with countries "DE" or "AU" and fix them, this will be done by ATU implementation
* You can run the demo and save vehicles with countries "FR", "IT", "ES", "PT" or "BE" and fix them, this will be done by Norauto implementation
* Try to create a vehicle in another country and you'll get an error when fixing them
* Create a new module and add the country you want into the list of supported ones on the new module you've created
* Add the new module to the bootloader module
* Now, if you restart the app, the vehicles of the country you've added should be able to be fixed without making any change on the other layers of your code

Congratulations! the second part is done

Thanks for reading and thanks for youre interest. 
Enjoy!!!