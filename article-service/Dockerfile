FROM openjdk:11

EXPOSE 8082

ADD target/article-service-docker.jar article-service-docker.jar

ENTRYPOINT ["java","-jar", "article-service-docker.jar"]