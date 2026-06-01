FROM eclipse-temurin:17
LABEL maintainer="contato@joaovqmartins.dev"
WORKDIR /app
COPY target/DockerTraining-0.0.1-SNAPSHOT.jar /app/aula-docker.jar
ENTRYPOINT ["java","-jar", "aula-docker.jar"]
EXPOSE 8080
