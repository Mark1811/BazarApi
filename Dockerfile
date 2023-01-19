FROM openjdk:19
COPY target/bazar-0.0.1-SNAPSHOT.jar bazarApp.jar
ENTRYPOINT ["java","-jar","/bazarApp.jar"]

