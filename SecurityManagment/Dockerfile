FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/services-0.0.1.jar
COPY ${JAR_FILE} security_management.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "security_management.jar"]