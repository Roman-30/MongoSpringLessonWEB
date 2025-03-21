FROM maven:3.9.0-eclipse-temurin-17-alpine AS builder
COPY ./pom.xml ./pom.xml
COPY ./src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17
WORKDIR "/app"
COPY --from=builder target/*.jar /demo3-0.0.1-SNAPSHOT.jar


#ENTRYPOINT ["java", "-jar", "/demo3-0.0.1-SNAPSHOT.jar"]
#
##ENTRYPOINT ["java", "-jar", "app.jar"]
#FROM openjdk:17-jdk-slim
#
##ENV SPRING_DATA_MONGODB_URI="mongodb://${MONGO_USER}:${MONGO_PASSWORD}@mongo:27017/${MONGO_DATABASE}"
##ENV MONGO_USER="root"
##ENV MONGO_PASSWORD="12345678"
##ENV MONGO_DATABASE="admin"
#
#WORKDIR /app
#COPY target/demo3-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]