# Projeto Spring Boot - Professor Nelio

## Objetivos:

     Criar projeto Spring Boot Java
     Implementar modelo de domínio
     Estruturar camadas lógicas: resource, service, repository
     Configurar banco de dados de teste (H2)
     Povoar o banco de dados
     CRUD - Create, Retrieve, Update, Delete
     Tratamento de exceções


## Tecnologias

- Spring Boot
- H2
- Maven
- PostgreSQL
- Postman
- JPA


## Domain Model 

![](.README_images/b0d2e6d1.png)

## Domain Instance

![](.README_images/8a96e589.png)

## Lógica Lyers

![](.README_images/a642fce3.png)


## User entity and resource

Basic entity checklist:

     Basic attributes
     Associations (instantiate collections)
     Constructors
     Getters & Setters (collections: only get)
     hashCode & equals
     Serializable

Observação: 
- como será usado o Framework deve ser incluido o construtor vazio
- o Serializable deve ser inserido quando queremos que os nossos dados sejam transformados em cadeias de bytes
e isso é feito para que o objeto trafegue na rede, para que o objeto seja gravado em arquivo ...