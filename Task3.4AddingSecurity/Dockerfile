
FROM openjdk:18.0.1.1-jdk-slim


WORKDIR /Task3.4AddingSecurity/app

COPY pom.xml .

COPY src ./Task3.4AddingSecurity/src
RUN ./Task3.4AddingSecurity/mvnw clean package

COPY target/your-app-name.jar /app/your-app-name.jar


EXPOSE 8080

CMD ["java", "-jar", "your-app-name.jar"]