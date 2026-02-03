FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY target/lifeflow-0.0.1-SNAPSHOT.jar.original app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
