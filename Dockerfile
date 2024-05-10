FROM openjdk:17-alpine

WORKDIR /app

COPY target/beneficioapi-0.0.1-SNAPSHOT.jar /app/beneficioapi.jar

CMD ["java", "-jar", "beneficioapi.jar"]