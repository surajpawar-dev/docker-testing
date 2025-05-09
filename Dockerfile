# First stage: Build the application
FROM maven:3.8-openjdk-17 AS builder

# Set working directory
WORKDIR /app

# Copy pom.xml first to leverage Docker cache
COPY pom.xml .

# Download all dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Second stage: Run the application
FROM openjdk:17-slim

WORKDIR /usr/app/

# Copy only the JAR file from the builder stage
COPY --from=builder /app/target/namaste.jar .

# Run the application
ENTRYPOINT ["java", "-jar", "namaste.jar"]