# Étape 1 : construire l'app avec Gradle
FROM gradle:8.4-jdk17 AS build
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle build --no-daemon

# Étape 2 : image finale avec juste le jar
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
