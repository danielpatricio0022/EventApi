# API de Gestão de Clientes e Pedidos

API RESTful para gerenciar clientes e pedidos, com endpoints para cadastro de clientes, criação, consulta e exclusão de pedidos. Inclui validação de dados, controle de limite de crédito e rate limiting.

## Endpoints

### 1. Cadastro de Clientes

**Requisição:**

```http
POST /clientes
