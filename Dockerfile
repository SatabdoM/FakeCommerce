# ---- Stage 1: Build ----
FROM eclipse-temurin:21-jdk-jammy AS builder

WORKDIR /app
COPY . .

RUN chmod +x gradlew
RUN ./gradlew clean build -x test

# ---- Stage 2: Run ----
FROM eclipse-temurin:25-jdk-jammy

WORKDIR /app

COPY --from=builder /app/build/libs/FakeCommerce-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
