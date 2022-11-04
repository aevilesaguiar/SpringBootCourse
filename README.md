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

## Inicio do Projeto

Será utilizado o H2 para os testes com Banco.

    -> TESTE para verificar se o Banco H2 está ok
        http://localhost:8080/h2-console

Será criado um profile de test, que é um perfil específico para fazer teste. 
Podem ser criados diversos perfis, como dev com o outro banco, produção quando o perfil está implantado
no cliente que vai utilizat o sistema

Checklist:

         JPA & H2 dependencies
         application.properties
         application-test.properties
         Entity: JPA mapping

Dependencies:

        <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
                <groupId>com.h2database</groupId>
                <artifactId>h2</artifactId>
                <scope>runtime</scope>
        </dependency>

application.properties:

        spring.profiles.active=test
        spring.jpa.open-in-view=true

application-test.properties:

        spring.datasource.url=jdbc:h2:mem:testdb
        spring.datasource.username=sa
        spring.datasource.password=
        spring.h2.console.enabled=true
        spring.h2.console.path=/h2-console
        spring.jpa.show-sql=true
        spring.jpa.properties.hibernate.format_sql=true 





## Mecanismo de banco de dados H2

H2 é um banco de dados relacional escrito em Java. Ele pode ser integrado em aplicativos Java ou executado no 
modo cliente-servidor.

Todos os modos contam com suporte para bancos de dados persistentes e na memória. Não há limite para o 
número de bancos de dados abertos simultaneamente ou para o número de conexões abertas.



- Características H2

  Muito rápido, código aberto, API JDBC
  Modos incorporados e de servidor; bancos de dados na memória
  Aplicativo de console baseado em navegador
  Tamanho pequeno: cerca de 2,5 MB de tamanho de arquivo jar


##  JPA - Jakarta Persistence

Jakarta Persistence ( JPA ; anteriormente Java Persistence API) é uma especificação de interface de programação de 
aplicativos Jakarta EE que descreve o gerenciamento de dados relacionais em aplicativos Java corporativos .

JPA é um framework leve, baseado em POJOS (Plain Old Java Objects) para persistir objetos Java. 
A Java Persistence API, diferente do que muitos imaginam, não é apenas um framework para Mapeamento 
Objeto-Relacional (ORM - Object-Relational Mapping), ela também oferece diversas funcionalidades 
essenciais em qualquer aplicação corporativa.

Atualmente temos que praticamente todas as aplicações de grande porte utilizam JPA para persistir 
objetos Java.

Ferramenta Objeto relacional padrão do Java, essa ferramenta faz uma conversão entre o modelo OO que você
desenvolve em java e o paradigma relacional que é o do Banco de Dados Relacional. E ela faz automaticamente.



- POJOS Persistentes: Talvez o aspecto mais importante da JPA seja o fato que os objetos são POJOs (Plain Old Java Object 
ou Velho e Simples Objeto Java), significando que os objetos possuem design simples que não dependem da herança de 
interfaces ou classes de frameworks externos. Qualquer objeto com um construtor default pode ser feito persistente 
sem nenhuma alteração numa linha de código. Mapeamento Objeto-Relacional com JPA é inteiramente dirigido a metadados. 
Isto pode ser feito através de anotações no código ou através de um XML definido externamente.


## Spring Data JPA 

O Spring Data JPA é uma implementação da abstração de repositório que é um bloco de construção chave do design orientado
a domínio baseado na estrutura de aplicativo Java Spring . Ele suporta de forma transparente todas as implementações de 
JPA disponíveis e suporta operações CRUD , bem como a execução conveniente de consultas de banco de dados.

## Referencias

- https://www.h2database.com/html/main.html
- https://gasparbarancelli.com/post/banco-de-dados-h2-com-spring-boot