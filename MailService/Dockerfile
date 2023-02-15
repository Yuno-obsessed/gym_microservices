FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file to the working directory
COPY target/mail-service.jar /app/

# Expose the port used by the application
EXPOSE 8083

# Run the application
CMD ["java", "-jar", "mail-service.jar"]