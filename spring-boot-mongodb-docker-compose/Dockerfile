# FROM openjdk:8-jdk-alpine
# VOLUME /tmp
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]


FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
ADD target/spring-boot-mongodb-docker-compose-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]