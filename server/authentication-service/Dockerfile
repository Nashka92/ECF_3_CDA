FROM maven:3.8.5-openjdk-11 AS builder
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests


FROM openjdk:11-jre-slim
WORKDIR /app

COPY --from=builder /app/target/authentication-service.jar app.jar

EXPOSE 7000

ENV JAVA_OPTS=""

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
