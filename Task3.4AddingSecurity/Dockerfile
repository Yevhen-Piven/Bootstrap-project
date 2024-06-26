
FROM openjdk:18.0.1.1-jdk-slim


WORKDIR /app

COPY pom.xml .

COPY src ./src
RUN ./mvnw clean package

COPY target/your-app-name.jar /app/your-app-name.jar


EXPOSE 8080

CMD ["java", "-jar", "your-app-name.jar"]