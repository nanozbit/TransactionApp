FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/services-0.0.1.jar
COPY ${JAR_FILE} account_managment.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "account_managment.jar"]