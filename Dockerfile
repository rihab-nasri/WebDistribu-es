FROM openjdk:17
EXPOSE 8089
ADD target/StagiaireMSA-0.0.1-SNAPSHOT.jar docker-sts.jar
ENTRYPOINT ["java","-jar","docker-sts.jar"]