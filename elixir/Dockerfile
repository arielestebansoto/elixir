FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/elixir-0.0.1.jar
COPY ${JAR_FILE} app_elixir.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_elixir.jar"]