# Microsserviços 

## Objetivo

Desenvolvimento com as principais tecnologias aprendidas nas trilhas de conhecimento de Java com SpringBoot para Backend:

- Desenvolvimento de 2 microserviços, um para controle de usuários e outro de mensageria.
- Integração com API ViaCep para preenchimento de endereço automático.
- Implementação de controle de endpoints através de autenticação e autorização com token JWT.
- Implementação de mensageria para comunicação entre microserviços com apache kafka e zookeeper.
- Dockerização da aplicação via docker compose.
- Deploy na AWS em uma instancia EC2, se aplicável.

## Ferramentas utilizadas:
- Java Development Kit (JDK) 17
- SpringBoot 3
- MySQL 8
- OpenFeign
- Apache Kafka
- Zookeeper
- Docker e docker compose
- AWS EC2

## Requisitos:

1. Endpoints:
a. Registro de Usuário: **POST /api/users/register**
b. Atualização de Senha: **PUT /api/users/update-password**
2. Segurança:
a. Implementar Spring Security com autenticação JWT.
b. O endpoint de Registro de Usuário deve estar acessível a todos.
c. O endpoint de Atualização de Senha deve ser restrito a usuários autenticados.
3. Mensageria:
a. Utilizar Kafka ou RabbitMQ para enviar mensagens para um microserviço chamado "notify".
b. O microserviço "notify" deve receber a mensagem e imprimi-la no console.
4. Integração com ViaCEP:
a. No cadastro do usuário, buscar o endereço a partir do CEP utilizando a API ViaCEP
5. Docker Compose para utilizar o kafka e o Zookeeper, facilitando assim a correção
