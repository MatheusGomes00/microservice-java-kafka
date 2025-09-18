# Gerar o build dentro do container
FROM maven:3.9.11-eclipse-temurin-17-alpine AS build
WORKDIR /msUser
COPY . .
RUN mvn clean package -DskipTests


# Executar o .jar gerado
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY --from=build /msUser/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]