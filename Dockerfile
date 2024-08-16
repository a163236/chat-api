FROM eclipse-temurin:21-alpine

COPY ./build/libs .

CMD ["java", "-jar", "chat-api-0.0.1-SNAPSHOT.jar"]