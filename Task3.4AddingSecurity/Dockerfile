
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY /pom.xml ./pom.xml
COPY /src ./src

RUN ./mvnw clean package

COPY target\bootstrapproject-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "your-app-name.jar"]