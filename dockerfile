FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/demo3-0.0.1-SNAPSHOT.jar demo3-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/demo3-1.0.0.jar"]