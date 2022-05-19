FROM openjdk:17-alpine

ADD ./bootloader/target/bootloader-0.0.1-SNAPSHOT.jar /norauto/demo.jar
EXPOSE 8080
WORKDIR /norauto

ENTRYPOINT ["java", "-jar", "demo.jar"]
