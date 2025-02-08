FROM maven:3.9-eclipse-temurin-17

WORKDIR /app

# Copiar o pom.xml e dependências antes para caching de dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar o código fonte e rodar o build
COPY src /app/src
RUN mvn package -DskipTests