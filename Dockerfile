FROM openjdk

COPY target/*.jar chatapp.jar

ENTRYPOINT ["java","-jar","/chatapp.jar"]
