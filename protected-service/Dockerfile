FROM openjdk

WORKDIR /app

COPY target/protected-service-1.0-SNAPSHOT.jar ./app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]

# Run:
#   'docker build -t ivangorbunovv/protected-service-image .'
