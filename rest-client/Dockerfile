FROM openjdk:8-jdk-alpine
WORKDIR /app
ADD build/libs/rest-client*.jar app.jar
EXPOSE 8081
CMD ["/usr/bin/java", "-jar", "app.jar"]