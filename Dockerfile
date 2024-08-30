FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY build/libs/car-service-tracker.jar /app/car-service-tracker.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/tu-app.jar"]
