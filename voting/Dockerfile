FROM openjdk:17-jdk
WORKDIR /voting
COPY build/libs/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]