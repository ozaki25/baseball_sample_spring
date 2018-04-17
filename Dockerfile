FROM openjdk:8-jdk-alpine
VOLUME /tmp
CMD ["mvn","package"]
# ENTRYPOINT ["java","-jar","./target/baseball-0.0.1-SNAPSHOT.jar"]