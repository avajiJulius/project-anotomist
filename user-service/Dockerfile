FROM openjdk:11

EXPOSE 8081

ADD target/user-service-docker.jar user-service-docker.jar

ENTRYPOINT ["java", "-jar","user-service-docker.jar"]