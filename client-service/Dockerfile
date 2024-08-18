FROM openjdk

WORKDIR /app

COPY target/client-service-1.0-SNAPSHOT.jar ./app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]

# Run:
#   'docker build -t ivangorbunovv/client-service-image .'
