
# Monolith Spring Boot Project

## Instruções para Execução do Projeto "Product"

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

## Instruções para Execução do Projeto "Courses"

### Criar Novo Estudante
```sh
curl -X POST http://localhost:8080/api/students -H "Content-Type: application/json" -d '{"name": "John Doe"}'
{"id":1,"name":"John Doe","courses":null}%
```

### Criar Novo Curso
```sh
curl -X POST http://localhost:8080/api/courses -H "Content-Type: application/json" -d '{"name": "Math"}'
{"id":1,"name":"Math","students":null}%
```

### Visualizar Todos os Estudantes
```sh
curl -X GET http://localhost:8080/api/students
[{"id":1,"name":"John Doe","courses":[]},{"id":2,"name":"Jane Doe","courses":[]}]%
```

### Visualizar Todos os Cursos
```sh
curl -X GET http://localhost:8080/api/courses
[{"id":1,"name":"Math","students":[]},{"id":2,"name":"Arts","students":[]}]%
```

### Consultar Estudante Específico por ID
```sh
curl -X GET http://localhost:8080/api/students/1
{"id":1,"name":"John Doe","courses":[]}%
```

### Consultar Curso Específico por ID
```sh
curl -X GET http://localhost:8080/api/courses/1
{"id":1,"name":"Math","students":[]}%
```

### Atualizar Dados do Estudante
```sh
curl -X PUT http://localhost:8080/api/students/1 -H "Content-Type: application/json" -d '{"name": "John Smith"}'
{"id":1,"name":"John Smith","courses":null}%
```

### Atualizar Dados do Curso
```sh
curl -X PUT http://localhost:8080/api/courses/2 -H "Content-Type: application/json" -d '{"name": "Physics"}'
{"id":2,"name":"Physics","students":null}%
```

### Remover um Estudante
```sh
curl -X DELETE http://localhost:8080/api/students/1
```

### Cachear Curso no Redis
```sh
curl -X POST http://localhost:8080/api/courses/cache -H "Content-Type: application/json" -d '{"id": 1, "name": "Math"}'
```

### Recuperar Curso Cacheado do Redis
```sh
curl -X GET http://localhost:8080/api/courses/cache/1
{"id":1,"name":"Math","students":null}%
```

### Remover Curso Cacheado do Redis
```sh
curl -X DELETE http://localhost:8080/api/courses/cache/1
```

## Instruções para Execução do Projeto "Employee" - AT

### Gerar o JAR Executável e Configurar o Docker

1. **Gerar o JAR Executável**:
    ```sh
    mvn clean package
    ```

    O JAR gerado estará no diretório `target/` com o nome `monolith-spring-boot-0.0.1-SNAPSHOT.jar`.

2. **Executar a Aplicação com Docker**:
    - **Parar os containers MongoDB e Redis existentes** (se necessário):
      ```sh
      docker stop mongodb redis
      docker rm mongodb redis
      ```
    - **Construir e iniciar os containers**:
      ```sh
      sudo docker-compose up --build
      ```

    A aplicação estará disponível em `http://localhost:8080`.

### Testar os Endpoints no Postman

1. **Importar a Coleção Postman**:
   - Abra o Postman.
   - Vá até "Importar".
   - Selecione o arquivo JSON da coleção "SpringBootApp API Tests" disponível no repositório.

2. **Executar os Testes**:
   - Certifique-se de que os containers Docker estão rodando (`app`, `mongodb`, `redis`).
   - Utilize a coleção Postman importada para executar os testes dos endpoints. A coleção inclui testes para todas as funcionalidades implementadas na aplicação.

