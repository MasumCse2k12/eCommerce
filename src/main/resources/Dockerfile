# Use the official Maven/Java image to build the application
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the project files into the container
COPY . .

# Build the application using Maven
RUN mvn clean package -DskipTests

# Use AdoptOpenJDK image as the base image for running the application
FROM adoptopenjdk/openjdk17:alpine-jre

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the build stage to the container
COPY --from=build /app/target/eCommerce-1.0.jar .

# Expose the port that the application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "eCommerce-1.0.jar"]
