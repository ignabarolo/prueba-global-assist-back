FROM openjdk:17-jdk-alpine
COPY target/global.assist.back-0.0.1-SNAPSHOT.jar global.assist.back.jar
ENTRYPOINT ["java",  "-jar", "/global.assist.back.jar"]