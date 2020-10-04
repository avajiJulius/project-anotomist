FROM openjdk:11

EXPOSE 8181

ADD target/user-service-docker.jar user-service-docker.jar

ENTRYPOINT ["java", "-jar","user-service-docker.jar"]