
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY /pom.xml ./pom.xml
COPY /src ./src

RUN ./Task3.4AddingSecurity/mvnw clean package

COPY Task3.4AddingSecurity/target/bootstrapproject.jar /app/bootstrapproject.jar

CMD ["java", "-jar", "your-app-name.jar"]