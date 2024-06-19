FROM openjdk:17-jdk-alpine
COPY target/UserManagement-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 80 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
