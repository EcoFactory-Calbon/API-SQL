# 🌱 API-SQL - EcoFactory

API REST desenvolvida em **Spring Boot** para o gerenciamento de dados e funcionalidades do projeto **EcoFactory Calbon**.

A API implementa autenticação e autorização usando **Spring Security** e está hospedada na plataforma **Render**.

[![Status](https://img.shields.io/badge/Status-Live-brightgreen)](#)

### Links de Acesso (Produção)

* **API Base URL:** `https://api-sql-pdlt.onrender.com/`
* **Documentação (Swagger):** `https://api-sql-pdlt.onrender.com/swagger-ui.html`

---

## 🚀 Tecnologias Utilizadas

O *stack* principal do projeto é construído em torno do ecossistema Java e Spring, com deploy automatizado no Render.

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
<br/>
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
<br/>
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white)
<br/>
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
<br/>
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
<br/>
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
<br/>
![Render](https://img.shields.io/badge/Render-46E3B7?style=for-the-badge&logo=render&logoColor=black)
<br/>
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)


## ⚙️ Configuração de Ambiente

O projeto utiliza variáveis de ambiente para configurar a conexão com o banco de dados e os parâmetros de segurança.

### 1. Ambiente de Produção (Render)

No Render, as variáveis de ambiente **não** são lidas de um arquivo `.env`. Elas devem ser configuradas diretamente no dashboard do seu serviço:

1.  Vá para a seção "Environment" do seu serviço no Render.
2.  Adicione as seguintes variáveis:
    * `DB_URL`: (Ex: O URL do serviço de Banco de Dados do próprio Render)
    * `DB_USERNAME`: (O usuário do banco)
    * `DB_PASSWORD`: (A senha do banco)
### 2. Ambiente de Desenvolvimento (Local)

Para desenvolvimento local, crie um arquivo `.env` na raiz do projeto. Este arquivo **não deve ser versionado** (`.gitignore`).

**Exemplo de `.env`:**

* `DB_URL=jdbc:postgresql://SUA-URL-DO-BANCO`
* `DB_USERNAME=SeuUser`
* `DB_PASSWORD=suaSenha`


## 🔐 Autenticação (Spring Security)

Todos os endpoints protegidos da API esperam um Token JWT no cabeçalho `Authorization`.

**Fluxo de Autenticação:**

1.  Envie uma requisição `POST` para o endpoint de autenticação (ex: `/api/auth/login`).
    * *Nota: Você precisa substituir pelo seu endpoint de login real.*
    
    **Exemplo de Body (JSON):**
    ```json
    {
        "username": "usuario_de_teste",
        "password": "senha_de_teste"
    }
    ```

2.  A API irá retornar um token JWT (JSON Web Token).
    ```json
    {
        "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIi..."
    }
    ```

3.  Para todas as requisições futuras a endpoints protegidos, inclua este token no cabeçalho:
    `Authorization: Bearer <seu_token_jwt_aqui>`

---

## 📖 Documentação da API (Endpoints)

Este projeto utiliza Swagger (OpenAPI) para documentação interativa.

### Acesso Local
* **URL:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Acesso em Produção
* **URL:** `https://api-sql-pdlt.onrender.com/swagger-ui/index.html`

### Como usar o Swagger com Segurança

1.  Acesse a URL do Swagger-UI.
2.  No topo da página, clique no botão **"Authorize"**.
3.  Obtenha seu token JWT usando o fluxo de autenticação descrito acima.
4.  Na janela modal do Swagger, no campo "Value", cole o token completo, incluindo o prefixo `Bearer ` (ex: `Bearer eyJhbGci...`).
5.  Clique em "Authorize". Agora você pode testar todos os endpoints protegidos diretamente pela interface do Swagger.
