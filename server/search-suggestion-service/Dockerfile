# Étape 1 : Build avec Maven et Java 17
FROM maven:3.8.5-openjdk-17 AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests -B

# Étape 2 : Image d'exécution avec Java 17
FROM openjdk:17-slim
WORKDIR /app

COPY --from=builder /app/target/search-suggestion-service-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 10000

CMD ["java", "-Xmx256m", "-jar", "app.jar"]
