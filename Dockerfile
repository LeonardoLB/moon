FROM openjdk:11.0.8-jdk-slim
COPY ./build/libs/moon.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "moon.jar"]