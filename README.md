# Teste Projetada
Teste técnico para o processo seletivo na empresa **Projedata**.

O teste está escrito em Java e utilizando o Docker para executar os testes automatizados e a aplicação em si. Também está sendo utilizado o Maven para gerenciamento de bibliotecas de testes na aplicação.

### Como testar:

#### Subir o container:
``
docker compose up -d
``

#### Executar testes automatizados:
``
docker compose exec app mvn test
``

#### Executar a aplicação:
``
docker compose exec app java -jar target/test-projedata-1.0-SNAPSHOT.jar
``

#### Gerar arquivo .jar com o Maven:
``docker compose exec app mvn package -DskiptTests``