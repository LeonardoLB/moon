## Build
FROM gradle:jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean build --no-daemon

## Application
FROM openjdk:11.0.8-jdk-slim
EXPOSE 8080
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/moon.jar /app/
WORKDIR /usr/app
ENTRYPOINT ["java", "-jar", "/app/moon.jar"]