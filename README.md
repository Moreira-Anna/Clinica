# Clinica
![cli1](https://github.com/user-attachments/assets/455f6dda-1f6a-448a-adca-c123b9258ebc)
![cli24](https://github.com/user-attachments/assets/e655cd43-3bb9-4bbc-bbf3-5b8712e1c55a)

## Funcionalidade 

- Cadastro de Pacientes: Registra pacientes com nome, CPF, telefone, descrição e dia da consulta.
- Cadastro de Médicos: Permite o cadastro de médicos com nome, CRM e telefone.
- Geração a Visualização de Relatórios e relatórios em PDF utilizando JasperReports.
- Somente as pessoas com acesso ao sistema da clínica têm permissão para acessar o projeto.
## Visualização de cadrastra consulta

![cli3](https://github.com/user-attachments/assets/e4a9edf0-40c1-451f-9a7e-04d490f383fa)

##  Visualização de cadrastra medico e busca

![cli4](https://github.com/user-attachments/assets/e1585c30-d7de-49e7-8ef2-0a7ebd63947b)
![cli5](https://github.com/user-attachments/assets/169f3d9d-7bdd-4298-a766-fc4aca076f18)

## Visualização dos relatorios 

![cli6](https://github.com/user-attachments/assets/33e5aea7-4488-44cc-9620-f819210d75df)

## Introdução 

O aplicativo "Clínica" é uma solução que permite o gerenciamento de dados de forma versátil, com opções de salvamento em diferentes formatos: TXT, binário, e em banco de dados. A interface atual está integrada com o banco de dados, oferecendo uma experiência de usuário fluida e eficiente. Além disso, o aplicativo conta com uma funcionalidade de geração de relatórios, implementada através do JasperReports, permitindo que os usuários obtenham documentos e análises detalhadas diretamente a partir dos dados armazenados

## Exemplo de Criação da Tabela

```java
CREATE TABLE paciente (
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(15) NOT NULL
);
CREATE TABLE consulta (
    id SERIAL PRIMARY KEY,
    cpf_paciente VARCHAR(11) REFERENCES paciente(cpf),
    datacon DATE NOT NULL,
    descricao TEXT
);
CREATE TABLE medico (
    cfm VARCHAR(6) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(15) NOT NULL
);
```
## Links das aplicações utilizadas no projeto
- [NetBeans](https://netbeans.apache.org/front/main/download/index.html)
- [PostgreSQL](https://www.postgresql.org/download/)
- [Jaspersoft ](https://www.jaspersoft.com/products/jaspersoft-community)




