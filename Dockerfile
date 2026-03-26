# Fase de construcción
FROM maven:3.9.6-eclipse-temurin-21-jammy AS build
COPY . .
# Entramos a la carpeta donde realmente está el proyecto
WORKDIR /WebPancuBarber
RUN mvn clean package -DskipTests

# Fase de ejecución
FROM eclipse-temurin:21-jdk-jammy
# Copiamos el resultado final desde la carpeta interna
COPY --from=build /WebPancuBarber/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]