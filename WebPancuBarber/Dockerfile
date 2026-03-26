# Usamos una imagen que ya traiga Maven para no depender del archivo mvnw
FROM maven:3.9.6-eclipse-temurin-21-jammy AS build
COPY . .
# Compilamos usando el Maven del sistema
RUN mvn clean package -DskipTests

# Segunda etapa para que el archivo final sea liviano
FROM eclipse-temurin:21-jdk-jammy
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]