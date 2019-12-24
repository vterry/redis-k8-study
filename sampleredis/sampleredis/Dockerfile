FROM openjdk:8-jdk-alpine
WORKDIR /app
ADD target/sampleredis-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["/usr/bin/java", "-jar", "app.jar"]