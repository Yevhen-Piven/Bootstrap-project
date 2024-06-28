
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY /pom.xml ./pom.xml
COPY /src ./src

RUN ./mvnw clean package

COPY target/bootstrapproject.jar /app/bootstrapproject.jar

CMD ["java", "-jar", "your-app-name.jar"]