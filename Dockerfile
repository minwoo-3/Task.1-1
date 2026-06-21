FROM eclipse-temurin:21-jre
WORKDIR /app
COPY build/libs/task.1-1-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]# 1단계: 빌드
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app
COPY . .
RUN chmod +x gradlew
RUN ./gradlew bootJar -x test

# 2단계: 실행
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
