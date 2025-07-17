# build
FROM maven:3.9.10-eclipse-temurin-21-noble as build
WORKDIR /build

COPY . .

RUN mvn clean package -DskipTests

# runtime
FROM amazoncorretto:21
WORKDIR /app

COPY --from=build /build/target/*.jar ./event.jar

EXPOSE 8080
EXPOSE 9090

ENV TZ="America/Sao_Paulo"

ENTRYPOINT ["java", "-jar", "event.jar"]
