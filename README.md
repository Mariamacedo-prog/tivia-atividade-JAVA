# Cadastro de Beneficiários com documentos

Este projeto é uma aplicação Java Spring Boot que fornece uma API REST para gerenciar o cadastro de beneficiários. 

O sistema inclui operações básicas como cadastro, listagem, atualização e remoção de beneficiários, bem como a listagem de documentos associados a um beneficiário.


### Tecnologias Utilizadas
Java
Spring Boot
Spring Data JPA
H2 Database
Swagger
Spring Security


### application.properties
--------------------------------------------------

"Nome e Senha do usuario que vai logar no sistema"
spring.security.user.name=user
spring.security.user.password=user

--------------------------------------------------

"Indormações de onde o arquivo db está localizado"
spring.datasource.url=jdbc:h2:C:/git/db
spring.datasource.username=SA
spring.datasource.password=12345
spring.datasource.driver-class-name=org.h2.Driver

--------------------------------------------------
logging.level.springfox.documentation=DEBUG

"Configura o dialeto do Hibernate para o H2"
hibernate.dialect=org.hibernate.dialect.H2Dialect

"Create indica ao Hibernate para criar automaticamente as tabelas no banco de dados quando iniciar o aplicativo OU update que atualiza o esquema do banco de dados automaticamente com base nas alterações detectadas "
spring.jpa.hibernate.ddl-auto= update ou create 

--------------------------------------------------
OBS: CASO QUEIRA CRIAR AS TABELAS NA MÃO
CREATE TABLE BENEFICIARIO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    data_nascimento DATE NOT NULL,
    endereco VARCHAR(255),
    cidade VARCHAR(100),
    estado VARCHAR(50),
    cep VARCHAR(8)
);

CREATE TABLE DOCUMENTO (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_documento VARCHAR(50) NOT NULL,
    descricao VARCHAR(255),
    data_inclusao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NOT NULL,
    beneficiario_id INT,
    FOREIGN KEY (beneficiario_id) REFERENCES BENEFICIARIO(id)
);

--------------------------------------------------
### Clone o repositório:

git clone https://github.com/Mariamacedo-prog/tivia-atividade-JAVA.git

### Compile e execute o projeto usando o Maven:
mvn -U clean install spring-boot:run

ou 
mvn clean 
mvn -U install
mvn spring-boot:run

Link da documentação da API no Swagger: http://localhost:8080/swagger-ui/index.html
![image](https://github.com/Mariamacedo-prog/tivia-atividade-JAVA/assets/69858181/ffa822bd-ed72-4e31-bf57-37f51022ec0a)

### Endpoints:
POST      /api/beneficiarios
Cria o beneficiário e seus documentos.
![image](https://github.com/Mariamacedo-prog/tivia-atividade-JAVA/assets/69858181/f2f08897-caef-448f-aef7-df523847d52e)
![image](https://github.com/Mariamacedo-prog/tivia-atividade-JAVA/assets/69858181/8f18bc17-b46f-4760-ac44-2e6f578c6855)



GET      /api/beneficiarios
Lista todos os beneficiários.
![image](https://github.com/Mariamacedo-prog/tivia-atividade-JAVA/assets/69858181/cf597df9-6837-4343-96db-d066ffe84466)



GET      /api/beneficiarios/{id}
Lista um beneficiário pelo seu ID e caso não encontre, retorna a mensagem "Beneficiário não encontrado"
![image](https://github.com/Mariamacedo-prog/tivia-atividade-JAVA/assets/69858181/1f70a3bf-de95-497a-9a6d-6c21f60ec051)
![image](https://github.com/Mariamacedo-prog/tivia-atividade-JAVA/assets/69858181/9308b354-740b-4bbe-80fd-2593e2bd97ac)



PUT      /api/beneficiarios/{id}
Atualiza os dados cadastrais do beneficiario e caso não encontre, retorna a mensagem "Não foi possível atualizar o beneficiário"
![image](https://github.com/Mariamacedo-prog/tivia-atividade-JAVA/assets/69858181/fd4718a6-af86-4cfd-8bd4-c7463372b8fa)
![image](https://github.com/Mariamacedo-prog/tivia-atividade-JAVA/assets/69858181/179300fb-36bf-41cf-a180-1b4993ae3579)



DELETE      /api/beneficiarios/{id}
Remove o beneficiario e seus documentos e caso não encontre, retorna a mensagem "Beneficiario não encontrado!"
![image](https://github.com/Mariamacedo-prog/tivia-atividade-JAVA/assets/69858181/47738d6c-d17c-446b-8567-0ef80230635a)
![image](https://github.com/Mariamacedo-prog/tivia-atividade-JAVA/assets/69858181/46b93560-c00d-4294-8102-daacb514ad7f)


GET      /api/documentos/{beneficiarioId}
Lista todos os documentos de um determinado beneficiário e caso não encontre, retorna a mensagem "Não encontrados Documentos para este beneficiario!"
![image](https://github.com/Mariamacedo-prog/tivia-atividade-JAVA/assets/69858181/5cf8f65a-5b2e-468f-b3c1-3d876b33804c)
![image](https://github.com/Mariamacedo-prog/tivia-atividade-JAVA/assets/69858181/118e81f8-3f67-4ba2-9264-acb6a6322313)


POST      /api/documentos/{beneficiarioId}
Cria o documento para determinado beneficiário e caso não encontre o beneficiario, retorna a mensagem "Beneficiário não encontrado"
![image](https://github.com/Mariamacedo-prog/tivia-atividade-JAVA/assets/69858181/07d1e79d-824b-4c91-a319-8641eac16a26)
![image](https://github.com/Mariamacedo-prog/tivia-atividade-JAVA/assets/69858181/2efcea92-61d4-4da0-a196-f27efb378c20)


