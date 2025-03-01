#FROM openjdk:17
#ARG JAR_FILE=target/demo3-0.0.1-SNAPSHOT.jar
#WORKDIR /app
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","app.jar"]

FROM maven:3.9.0-eclipse-temurin-17-alpine AS builder
COPY ./pom.xml ./pom.xml
COPY ./src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:17-alpine-jdk
WORKDIR "/app"
COPY --from=builder /target/*.jar /demo3-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/demo3-0.0.1-SNAPSHOT.jar"]