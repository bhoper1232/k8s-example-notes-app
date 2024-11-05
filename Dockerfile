FROM openjdk:17
EXPOSE 8080
ADD target/todoapp-0.0.1-SNAPSHOT.jar notesapp.jar
ENTRYPOINT ["java", "-jar", "/notesapp.jar"]