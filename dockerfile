FROM openjdk:8

EXPOSE 8080

ADD target/AI_Shop-0.0.1-SNAPSHOT.jar AI_Shop-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "AI_Shop-0.0.1-SNAPSHOT.jar"]