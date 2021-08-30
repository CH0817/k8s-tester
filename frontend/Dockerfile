FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} frontend.jar
ENTRYPOINT ["java","-jar","/frontend.jar"]