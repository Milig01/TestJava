FROM openjdk:23-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8081:8081

ENTRYPOINT ["java","-jar","app.jar"]