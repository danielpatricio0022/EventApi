# Desafio de API - Gerenciamento de Eventos e Participantes

Esta API permite gerenciar eventos e participantes com funcionalidades para criar eventos, cadastrar participantes, verificar presença e consultar participantes de um evento.

## Endpoints

### 1. Criação de Evento

- **Requisição:**
  ```http
  POST /eventos

  {
    "nome": "Conferência de Tecnologia",
    "local": "Centro de Convenções",
    "data": "2024-12-15T10:00:00Z",
    "vagasTotais": 100
  } 

- nome: string obrigatória (5 a 100 caracteres).
- local: string obrigatória (5 a 100 caracteres).
- data: string no formato ISO 8601.
- vagasTotais: inteiro positivo representando o número total de vagas.

**Resposta de Sucesso (201 Created):**
   ```
  {
    "eventoId": 1,
    "nome": "Conferência de Tecnologia",
    "local": "Centro de Convenções",
    "data": "2024-12-15T10:00:00Z",
    "vagasTotais": 100,
    "vagasDisponiveis": 100
  }
  ```
**Regras:**

- Evento criado com todas as vagas disponíveis.
- Em caso de conflito de nome e data para o evento, retorna HTTP 409 Conflict.

**Cadastro de Participantes em um Evento**

 ```
POST /eventos/[id]/participantes
  {
    "nome": "Maria Oliveira",
    "email": "maria.oliveira@example.com"
  }
 ```
**Resposta de Sucesso (200 OK):**
 ```
{
  "participanteId": 10,
  "nome": "Maria Oliveira",
  "email": "maria.oliveira@example.com",
  "eventoId": 1,
  "status": true
}
 ```

**Regras:**
- Participante cadastrado se houver vagas disponíveis.
- Se o evento estiver lotado, retorna HTTP 422 Unprocessable Entity com mensagem "evento cheio".
- O e-mail deve ser único por evento; se o e-mail já estiver cadastrado, retorna HTTP 409 Conflict.

**Verificação de Presença em um Evento**

```
Requisição:
 POST /eventos/[id]/presenca

{
  "email": "maria.oliveira@example.com"
}
 ```

- id: na URL, número inteiro representando o ID do evento.
- email: string obrigatória representando o e-mail do participante.
- Resposta de Sucesso (200 OK):

 ```
{
  "participanteId": 10,
  "nome": "Maria Oliveira",
  "statusPresenca": true
}
 ```

**Regras:**
- Marca o participante como presente(true).
- Se já marcado como true, retorna HTTP 409 Conflict.
- Se o participante não estiver cadastrado, retorna HTTP 404 Not Found.


**Consulta de Participantes**
 ```
GET /eventos/[id]/participantes
Resposta de Sucesso (200 OK):

{
  "eventoId": 1,
  "nomeEvento": "Conferência de Tecnologia",
  "participantes": [
    {
      "participanteId": 10,
      "nome": "Maria Oliveira",
      "email": "maria.oliveira@example.com",
      "statusPresenca": True
    },
    {
      "participanteId": 11,
      "nome": "José da Silva",
      "email": "jose.silva@example.com",
      "statusPresenca": False
    }
  ]
}
 ```
- Se o evento não existir, retorna HTTP 404 Not Found.
