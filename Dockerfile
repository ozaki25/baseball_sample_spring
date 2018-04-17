FROM openjdk:8-jdk-alpine
VOLUME /tmp
CMD ["mvn", "package"]
ARG JAR_FILE	
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
