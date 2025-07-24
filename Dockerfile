# Use official Java image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper files
COPY mvnw .
COPY .mvn .mvn

# Copy source
COPY . .

# Build the application
RUN ./mvnw clean install -DskipTests

# Run the application
CMD ["./mvnw", "spring-boot:run"]
