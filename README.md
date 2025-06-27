# ⚽ Football API

Une API REST complète construite avec Spring Boot pour gérer les matchs, joueurs, stades, équipes et compétitions de football.

---

## 📌 Description

Cette API permet de :
- Créer, modifier, supprimer et consulter des **équipes**, **joueurs**, **matchs**, **stades** et **compétitions**
- Gérer les utilisateurs avec authentification JWT (rôles USER/ADMIN)
- Fournir une documentation Swagger publique
- Consommer l’API via Postman (collection fournie)

---

## 🚀 Déploiement public

🌐 [https://football-api-mxbx.onrender.com](https://football-api-mxbx.onrender.com)  
📘 Swagger UI : [https://football-api-mxbx.onrender.com/swagger-ui/index.html](https://football-api-mxbx.onrender.com/swagger-ui/index.html)

---

## 🧪 Collection Postman

📥 [Télécharger FootballAPI Collection (JSON)](postman/FootballAPI.postman_collection.json)

---

## 🛠️ Lancer le projet en local

### Prérequis

- Java 17+
- Gradle
- Git

### Étapes

```bash
# 1. Cloner le dépôt
git clone https://github.com/ChaiboubY07/FootballAPI_SpringBoot.git
cd FootballAPI_SpringBoot

# 2. Construire le projet
./gradlew build

# 3. Lancer l'application
./gradlew bootRun
```

L’API sera accessible sur : `http://localhost:8080`

---

## 🔒 Authentification

- Pour utiliser l’API, enregistrez un utilisateur via `/auth/register`
- Connectez-vous via `/auth/login` pour obtenir un **token JWT**
- Ajoutez ce token dans Postman (ou Swagger) en tant que `Bearer <token>`

---

## 📂 Structure du projet

- `src/main/java` : code source Java
- `src/main/resources` : configuration (application.properties, etc.)
- `postman/` : collection Postman
- `Dockerfile` : pour déploiement containerisé

---

## 📬 Contact

Développé par **CHaiboub YO.**

---

🔗 GitHub : [https://github.com/ChaiboubY07/FootballAPI_SpringBoot](https://github.com/ChaiboubY07/FootballAPI_SpringBoot)