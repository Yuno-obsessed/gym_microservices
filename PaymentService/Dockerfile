FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file to the working directory
COPY target/payment-service.jar /app/

# Expose the port used by the application
EXPOSE 8087

# Run the application
CMD ["java", "-jar", "payment-service.jar"]