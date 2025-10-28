## 🧩 Tipo de Mudança
- [ ] **Feat** (nova funcionalidade)
- [ ] **Fix** (correção de bug)
- [ ] **Refactor** (refatoração de código)
- [ ] **Docs** (documentação)
- [ ] **Test** (testes)
- [ ] **Chore** (tarefas gerais, configs, etc.)

---

## 🔍 Descrição da PR
...

---

## 🔗 Issues Relacionadas
- Ex: Closes #23

---

## ✅ Checklist de Qualidade

* [ ] Meu código segue as diretrizes de estilo deste projeto.
* [ ] Eu realizei uma auto-revisão (self-review) do meu próprio código.
* [ ] Eu testei esta mudança **localmente** e ela funciona como esperado.
* [ ] A documentação do Swagger foi atualizada (se aplicável).

---

## 🔐 Checklist de Segurança (Spring Security)

* [ ] **Não aplicável:** Minha mudança não toca em endpoints ou lógica de autenticação.
* [ ] **Aplicável:** Eu verifiquei os endpoints alterados:
    * [ ] Acesso **COM** autenticação (Token JWT) -> Funciona como esperado.
    * [ ] Acesso **SEM** autenticação -> Retorna 401/403 (Unauthorized/Forbidden) como esperado.

---

## 🌎 Checklist de Produção (Render)

* [ ] **NENHUMA** nova variável de ambiente é necessária no Render.


---

## 🧪 Como Testar (Passos para Reprodução)

1. Entre inicialize a aplicação e entre pelo ambiente local, ou entre no link do Render `https://api-sql-pdlt.onrender.com/swagger-ui/index.html`
2. No Swagger, vá para a parte de Autenticação e faça o Login
3. Depois com o login feito, vai retornar o token, com o token você vai para a parte superior em Authorize e adicione o token
