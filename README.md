# Microsserviços com Spring Boot e Kafka

## Objetivo

Este projeto tem como finalidade aplicar conceitos de **arquitetura de microsserviços** utilizando
as tecnologias da stack backend com Java e Spring Boot.

### Funcionalidades previstas:

* Desenvolvimento de **dois microsserviços**:
    - **User Service** → responsável pelo cadastro e gerenciamento de usuários.
    - **Notify Service** → responsável pela mensageria e notificações.
* Integração com a **API ViaCEP** para preenchimento automático de endereço.
* Implementação de **autenticação e autorização via JWT** para proteção dos endpoints.
* Comunicação entre microsserviços utilizando **Apache Kafka**.
* **Dockerização** da aplicação com `docker-compose`.

---

## Tecnologias e Ferramentas

* **Java Development Kit (JDK 17)**
* **Spring Boot 3**
* **Spring Security + JWT**
* **Spring Data JPA**
* **MySQL 8**
* **OpenFeign** (consumo da API ViaCEP)
* **Apache Kafka**
* **Docker & Docker Compose**

---