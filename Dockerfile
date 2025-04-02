FROM openjdk:17

COPY target/namaste.jar  /usr/app/

WORKDIR /usr/app/


ENTRYPOINT ["java", "-jar", "namaste.jar"]