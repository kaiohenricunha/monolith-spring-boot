
# Roteiro para Completar a Tarefa de Serviço Web REST Sem Estado

## Dia 1

### 1. Escolha da Ferramenta de Construção

- **Decisão**: Usar Maven.
- **Justificativa**: Maven é amplamente utilizado, tem documentação extensa e uma grande comunidade. Ele simplifica o gerenciamento de dependências por meio de uma configuração XML direta.

### 2. Início do Projeto

- **Spring Initializr**: Use a interface web para criar um projeto básico do Spring Boot com dependências como Spring Web.
- **Spring Boot CLI**: Use a CLI com um exemplo de comando:

  ```sh
  spring init --dependencies=web monolith-spring-boot
  ```

- **Justificativa**: A interface web é amigável e ideal para iniciantes, enquanto a CLI é mais rápida para desenvolvedores experientes.

### 3. Gerenciamento de Dependências

- **Gerenciamento Eficiente**: Use Maven para gerenciar dependências adicionando-as ao `pom.xml`.

  ```xml
  <dependencies>
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-web</artifactId>
      </dependency>
  </dependencies>
  ```

- **Justificativa**: Simplifica o gerenciamento de dependências.

### 4. Uso de Autoconfiguração

- **Implementação**: Garanta a autoconfiguração do Spring Boot minimizando definições manuais de beans e utilizando `application.properties` para configuração.

  ```properties
  spring.application.name=monolith-spring-boot
  server.port=8080
  logging.level.org.springframework.web=DEBUG
  logging.level.com.example=DEBUG
  ```

- **Justificativa**: Reduz o código boilerplate, tornando a aplicação mais manutenível.

### 5. Configuração do IDE

- **Configuração**: Configurar o IDE para projetos Spring Boot, incluindo a habilitação de anotações e suporte ao Spring Boot.
- **Justificativa**: Usar VS Code com as extensões Java necessárias e integração com o ambiente WSL para fácil administração do projeto em ambiente Linux.

![src/main/resources/static/ide.png]

- **Instalação Java**: A instalação foi feita e facilitada pelo [Jabba](https://github.com/shyiko/jabba):

```bash
history | grep jabba
   33  jabba ls-remote
   34  jabba install openjdk@1.17.0
  901  jabba use openjdk@1.17.0
  902  jabba alias default openjdk@1.17.0
```

```bash
java --version
openjdk 17 2021-09-14
OpenJDK Runtime Environment (build 17+35-2724)
OpenJDK 64-Bit Server VM (build 17+35-2724, mixed mode, sharing)
```

- **Maven**: O build e run do projeto foi feito da seguinte forma:

```bash
  924  mvn clean install
  925  mvn spring-boot:run
```

## Dia 2

### 1. Desenvolvimento de Serviços REST

- **Estrutura**: Criar um novo pacote `com.example.monolithspringboot.controller`.
- **Exemplo do Controller**:

  ```java
  package com.example.monolithspringboot.controller;

  import org.springframework.http.ResponseEntity;
  import org.springframework.web.bind.annotation.*;

  import java.util.Map;

  @RestController
  @RequestMapping("/api")
  public class MathController {

      @GetMapping("/add")
      public ResponseEntity<Integer> add(@RequestParam int a, @RequestParam int b) {
          return ResponseEntity.ok(a + b);
      }

      @PostMapping("/add")
      public ResponseEntity<Integer> addPost(@RequestBody Map<String, Integer> body) {
          return ResponseEntity.ok(body.get("a") + body.get("b"));
      }

      @GetMapping("/subtract")
      public ResponseEntity<Integer> subtract(@RequestParam int a, @RequestParam int b) {
          return ResponseEntity.ok(a - b);
      }

      @PostMapping("/subtract")
      public ResponseEntity<Integer> subtractPost(@RequestBody Map<String, Integer> body) {
          return ResponseEntity.ok(body.get("a") - body.get("b"));
      }

      @GetMapping("/multiply")
      public ResponseEntity<Integer> multiply(@RequestParam int a, @RequestParam int b) {
          return ResponseEntity.ok(a * b);
      }

      @PostMapping("/multiply")
      public ResponseEntity<Integer> multiplyPost(@RequestBody Map<String, Integer> body) {
          return ResponseEntity.ok(body.get("a") * body.get("b"));
      }

      @GetMapping("/divide")
      public ResponseEntity<Integer> divide(@RequestParam int a, @RequestParam int b) {
          if (b == 0) {
              return ResponseEntity.badRequest().body(null);
          }
          return ResponseEntity.ok(a / b);
      }

      @PostMapping("/divide")
      public ResponseEntity<Integer> dividePost(@RequestBody Map<String, Integer> body) {
          if (body.get("b") == 0) {
              return ResponseEntity.badRequest().body(null);
          }
          return ResponseEntity.ok(body.get("a") / body.get("b"));
      }

      @GetMapping("/exponentiate")
      public ResponseEntity<Integer> exponentiate(@RequestParam int a, @RequestParam int b) {
          return ResponseEntity.ok((int) Math.pow(a, b));
      }

      @PostMapping("/exponentiate")
      public ResponseEntity<Integer> exponentiatePost(@RequestBody Map<String, Integer> body) {
          return ResponseEntity.ok((int) Math.pow(body.get("a"), body.get("b")));
      }
  }
  ```

- **Justificativa**: Demonstrar ambos os métodos GET e POST para cada operação.

````bash
curl -X GET "http://localhost:8080/api/add?a=5&b=3"
# 8

curl -X POST "http://localhost:8080/api/add" -H "Content-Type: application/json" -d '{"a": 5, "b": 3}'
# 8

curl -X GET "http://localhost:8080/api/subtract?a=5&b=3"
# 2

curl -X POST "http://localhost:8080/api/subtract" -H "Content-Type: application/json" -d '{"a": 5, "b": 3}'
# 2

curl -X GET "http://localhost:8080/api/multiply?a=5&b=3"
# 15

curl -X POST "http://localhost:8080/api/multiply" -H "Content-Type: application/json" -d '{"a": 5, "b": 3}'
# 15

curl -X GET "http://localhost:8080/api/divide?a=6&b=3"
# 2

curl -X POST "http://localhost:8080/api/divide" -H "Content-Type: application/json" -d '{"a": 6, "b": 3}'
# 2

curl -X GET "http://localhost:8080/api/exponentiate?a=2&b=3"
# 8

curl -X POST "http://localhost:8080/api/exponentiate" -H "Content-Type: application/json" -d '{"a": 2, "b": 3}'
# 8
```

### 2. Entrega e Formato do Relatório

- **Documentação**: Criar um relatório detalhado em markdown ou um processador de texto, cobrindo cada estágio do projeto, com exemplos de código e capturas de tela.
- **Submissão no Repositório**: Enviar o código para um repositório no GitHub e fornecer acesso aos revisores.
