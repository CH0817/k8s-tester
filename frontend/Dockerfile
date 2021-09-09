FROM openjdk:8-jdk-alpine
ADD target/frontend.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]