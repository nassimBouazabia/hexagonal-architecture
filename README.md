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
