# Usando a imagem base do Maven com OpenJDK 17
FROM maven

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo pom.xml e baixa as dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código-fonte
COPY src /app/src

# Compila o projeto e empacota o JAR
RUN mvn package -DskipTests

# Comando para executar a aplicação
CMD ["java", "-jar", "target/test-projedata-1.0-SNAPSHOT.jar"]