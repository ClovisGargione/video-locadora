FROM maven:3.9-amazoncorretto-21-al2023 AS build
WORKDIR /video-locadora
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21
WORKDIR /video-locadora
COPY --from=build ./video-locadora/target/*.jar ./video-locadora.jar
ENTRYPOINT ["java", "-jar", "video-locadora.jar"]