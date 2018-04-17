FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE	
ADD ${JAR_FILE} app.jar
RUN ["java","-jar","/app.jar"]
