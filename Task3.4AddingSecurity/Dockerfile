
FROM openjdk:17-jdk-slim


WORKDIR /app

COPY pom.xml .

COPY Task3.4AddingSecurity/pom.xml ./pom.xml
COPY Task3.4AddingSecurity/src ./src
COPY Task3.4AddingSecurity/mvnw ./mvnw
COPY Task3.4AddingSecurity/.mvn ./.mvn

RUN ./mvnw clean package

COPY target/bootstrapproject.jar /app/bootstrapproject.jar


EXPOSE 8080

CMD ["java", "-jar", "bootstrapproject.jar"]