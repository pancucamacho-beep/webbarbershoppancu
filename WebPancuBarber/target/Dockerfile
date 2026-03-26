FROM eclipse-temurin:21-jdk-jammy
COPY . .
RUN ./mvnw clean install -DskipTests
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/*.jar"]