FROM openjdk:8-jdk-alpine

VOLUME /tmp

COPY ./target/wordladder-0.0.1-SNAPSHOT.jar  app.jar

COPY src/main/resources/static/dictionary.txt src/main/resources/static/dictionary.txt 

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]