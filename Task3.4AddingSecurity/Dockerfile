
FROM openjdk:18-jdk-slim


WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN ./mvnw clean package

COPY target/app.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]