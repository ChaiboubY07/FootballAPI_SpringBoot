# Utilise une image Java officielle (OpenJDK 17)
FROM openjdk:17

# Dossier de travail dans le conteneur
WORKDIR /app

# Copie le jar généré dans le conteneur
COPY build/libs/*.jar app.jar

# Expose le port utilisé par Spring Boot
EXPOSE 8080

# Commande de démarrage
ENTRYPOINT ["java", "-jar", "app.jar"]
