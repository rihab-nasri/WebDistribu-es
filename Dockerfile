FROM openjdk:8
EXPOSE 8089
ADD target/DemandeConge-0.0.1-SNAPSHOT.jar docker-sts.jar
ENTRYPOINT ["java","-jar","docker-sts.jar"]
