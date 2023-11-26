FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.8-jdk-slim
COPY --from=build /target/api.linertec-0.0.1-SNAPSHOT.jar api.linertec.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","api.linertec.jar"]