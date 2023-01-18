FROM openjdk:18
COPY target/bazar-0.0.1-SNAPSHOT.jar bazar.jar
ENTRYPOINT ["java","-jar","/bazar.jar"]