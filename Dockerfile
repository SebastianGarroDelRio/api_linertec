FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.8-jdk-slim
COPY --from=build /target/app.linertec-0.0.1-SNAPSHOT.jar app.linertec.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.linertec.jar"]