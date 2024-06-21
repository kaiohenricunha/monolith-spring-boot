
# Monolith Spring Boot Project

## Instruções para Execução do Projeto

1. **Clone o repositório**:
    ```sh
    git clone <URL do repositório>
    cd monolith-spring-boot
    ```

2. **Instale as dependências**:
    ```sh
    mvn clean install
    ```

3. **Execute a aplicação**:
    ```sh
    mvn spring-boot:run
    ```

A aplicação estará disponível em `http://localhost:8080`.

## Testes dos Endpoints

### Criar Novo Produto
```sh
curl -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d '{"name": "New Product", "price": 100.0}'
{"id":1,"name":"New Product","description":null,"price":100.0}%
```

### Visualizar Todos os Produtos
```sh
curl -X GET http://localhost:8080/api/products
[{"id":1,"name":"New Product","description":null,"price":100.0}]%
```

### Consultar Produto Específico por ID
```sh
curl -X GET http://localhost:8080/api/products/1
{"id":1,"name":"New Product","description":null,"price":100.0}% 
```

### Atualizar Dados do Produto
```sh
curl -X PUT http://localhost:8080/api/products/1 -H "Content-Type: application/json" -d '{"name": "Apple", "price": 120.0}'
{"id":1,"name":"Apple","description":null,"price":120.0}%
```

### Remover um Produto
```sh
curl -X DELETE http://localhost:8080/api/products/1
```

```sh
curl -X GET http://localhost:8080/api/products
[]%
```
