# Etapa 1: Construcción (Maven con Java 21)
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copiamos solo el pom.xml primero para aprovechar la caché de capas de Docker
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el código fuente y empaquetamos
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagen de ejecución (JRE 21)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiamos el jar generado desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto de Spring Boot
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
