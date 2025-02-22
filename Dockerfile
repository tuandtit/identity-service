# Stage 1: build
# Start with a Maven image that includes JDK 21
#FROM maven:3.9.9-amazoncorretto-17 AS build
#
## Copy source code and pom.xml file to /app folder
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
#
## Build source code with maven
#RUN mvn package -DskipTests

#Stage 2: create image
# Start with Amazon Correto JDK 17
#FROM amazoncorretto:17.0.14
#
## Set working folder to App and copy complied file from above step
#WORKDIR /app
#COPY --from=build /app/target/*.jar app.jar
#
## Command to run the application
#ENTRYPOINT ["java", "-jar", "app.jar"]
FROM amazoncorretto:17.0.14

ARG FILE_JAR=target/*.jar

COPY ${FILE_JAR} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8080