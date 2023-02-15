FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file to the working directory
COPY target/user-service.jar /app/

# Expose the port used by the application
EXPOSE 8082

# Run the application
CMD ["java", "-jar", "user-service.jar"]