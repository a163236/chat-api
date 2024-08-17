FROM eclipse-temurin:21-alpine

COPY . .
CMD ["./gradlew build"]
CMD ["java", "-jar", "build/libs/chat-api.jar"]