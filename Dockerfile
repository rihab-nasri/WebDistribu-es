FROM openjdk:17
EXPOSE 8082
ADD target/sprint-service-0.0.1-SNAPSHOT.jar sprint-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "sprint-service-0.0.1-SNAPSHOT.jar"]

 