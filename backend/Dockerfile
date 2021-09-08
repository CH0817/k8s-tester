FROM openjdk:11.0.12-slim-buster
ADD target/backend.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]