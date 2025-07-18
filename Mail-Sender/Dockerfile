# build
FROM maven:3.9.10-eclipse-temurin-21-noble as build
WORKDIR /build

COPY . .

RUN mvn clean package -DskipTests

# runtime
FROM amazoncorretto:21
WORKDIR /app

COPY --from=build /build/target/*.jar ./mail.jar

EXPOSE 8081

ENV TZ="America/Sao_Paulo"

ENTRYPOINT ["java", "-jar", "mail.jar"]
