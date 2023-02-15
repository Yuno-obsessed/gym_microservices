FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file to the working directory
COPY target/order-service.jar /app/

# Expose the port used by the application
EXPOSE 8086

# Run the application
CMD ["java", "-jar", "order-service.jar"]