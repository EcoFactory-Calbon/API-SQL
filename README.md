# 🌱 API-SQL - EcoFactory

API REST desenvolvida em **Spring Boot** para o gerenciamento de dados e funcionalidades do projeto **EcoFactory Calbon**.  
O projeto segue boas práticas de arquitetura em camadas (Controller → Service → Repository → Database) e pode ser executado localmente ou em container Docker.

---

## 🚀 Tecnologias Utilizadas
- [Java 17+](https://adoptium.net/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Hibernate](https://hibernate.org/)
- [PostgreSQL](https://www.postgresql.org/) *(ou outro banco suportado)*
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- [Swagger / OpenAPI](https://swagger.io/) *(se configurado)*

---

## ⚙️ Configuração do Ambiente

### 🔹 Arquivo `.env`
Crie um arquivo **.env** na raiz do projeto para armazenar variáveis de ambiente.  
Esse arquivo **não deve ser versionado** (adicione no `.gitignore`).

Exemplo de `.env`:
```env
DB_URL=jdbc:postgresql://localhost:5432/api_calbon
DB_USERNAME=usuario
DB_PASSWORD=senha
