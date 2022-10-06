# Projeto módulo 3 Spring Boot

## Spring Framework
Conjunto de bibliotecas escritas em Java para simplificar o desenvolvimento de aplicações WEB

## Spring Boot
Ferramenta para acelerar o início de um projeto utilizando o Spring Framework
- Documentação: https://spring.io/projects/spring-boot
- Start: https://start.spring.io/
Site que cria a estrutura de um projeto utilizando o Spring Boot

## Configuração do ambiente
- Java Development Kit (JDK)
- Maven (gerenciador de pacotes e ferramenta de build)
- VSCode
  - Extension Pack for Java (Microsoft)
  - Extension Pack for Spring Boot (Pivotal)
- Banco de dados (MariaDB)

## Passo a passo para criar um novo projeto Springboot no VScode
- Criar uma pasta no disco do computador
- Abrir a pasta no VSCode usando a opção File -> Open Folder
- Ctrl + Shift + P
= Digitar Spring Initializer: Create a Maven Project
- Qual a versão do Spring Framework(a ultima)
- Qual a linguagem Java
- Qual o pacote base do projeto: com.br(dominio da empresa)

## Configuração para conexão no bando de dados relacional
- Adicionar dependencias( Spring data JPA, H2, MariaDB JDBC Driver)
- Configurar a conexão da aplicação com o banco de dados no arquivo application.properties.

## Estrutura do projeto
- Pacote src: todo o código da aplicação (Java, HTML, CSS, JS)
- Pacote target: código compilado e gerado pelo Maven
- Arquivo pom.xml: arquivo descritor utilizado pelo Maven para download das dependências e build de aplicação
- <nomedoprojeto>Application.java - main da aplicação Java
- Pacote controller: classes que são responsáveis por tratar as requisições HTTP enviadas para as rotas definidas por anotação


## Executar a aplicação
- Encontrar o Spring Boot Dashboard
- Clicar no icone de Play do lado do nome do projeto


insert into cliente(nome, endereco, sexo) values ('zeze', 'lalalala', 'masculino')