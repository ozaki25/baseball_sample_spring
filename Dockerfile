FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE	
ADD ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]
ENTRYPOINT ["mvn", "package", "&&", "java", "-jar", "./target/baseball-0.0.1-SNAPSHOT.jar"]