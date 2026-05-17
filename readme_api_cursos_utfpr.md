# API Cursos UTFPR

API REST desenvolvida com Spring Boot para gerenciamento acadêmico de:

- Alunos
- Cursos
- Matrículas

A aplicação permite realizar operações completas de CRUD, validações com Jakarta Validation, relacionamentos entre entidades e documentação automática da API utilizando Scalar/OpenAPI.

---

# Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Jakarta Validation
- Lombok
- OpenAPI
- Scalar
- Maven

---

# Funcionalidades

## Alunos

- Cadastro de alunos
- Consulta por ID
- Listagem paginada
- Atualização de dados
- Remoção de alunos

## Cursos

- Cadastro de cursos
- Consulta por ID
- Listagem paginada
- Atualização de cursos
- Remoção de cursos

## Matrículas

- Cadastro de matrículas
- Associação entre aluno e curso
- Consulta por ID
- Listagem paginada
- Atualização de matrículas
- Exclusão de matrículas

---

# Relacionamentos

- Um aluno pode possuir várias matrículas
- Um curso pode possuir várias matrículas
- Uma matrícula pertence a um único aluno
- Uma matrícula pertence a um único curso

---

# Estrutura da API

## Endpoints de Alunos

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/aluno` | Cadastra um aluno |
| GET | `/aluno/{id}` | Busca aluno por ID |
| GET | `/aluno` | Lista alunos paginados |
| PUT | `/aluno/{id}` | Atualiza um aluno |
| DELETE | `/aluno/{id}` | Remove um aluno |

---

## Endpoints de Cursos

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/curso` | Cadastra um curso |
| GET | `/curso/{id}` | Busca curso por ID |
| GET | `/curso` | Lista cursos paginados |
| PUT | `/curso/{id}` | Atualiza um curso |
| DELETE | `/curso/{id}` | Remove um curso |

---

## Endpoints de Matrículas

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/matricula` | Cadastra uma matrícula |
| GET | `/matricula/{id}` | Busca matrícula por ID |
| GET | `/matricula` | Lista matrículas paginadas |
| PUT | `/matricula/{id}` | Atualiza uma matrícula |
| DELETE | `/matricula/{id}` | Remove uma matrícula |

---

# Paginação

Os endpoints de listagem suportam paginação automática utilizando Spring Pageable.

## Exemplo

```http
GET /aluno?page=0&size=10&sort=nome,asc
```

## Parâmetros

| Parâmetro | Descrição |
|---|---|
| page | Número da página |
| size | Quantidade de registros |
| sort | Campo e direção |

---

# Validações

A API utiliza Jakarta Validation para validação automática dos dados.

## Exemplos

- Nome obrigatório
- E-mail válido
- Idade mínima
- Carga horária positiva
- Campos booleanos obrigatórios

---

# Documentação da API

A documentação da API é gerada automaticamente utilizando Scalar/OpenAPI.

## Acessar documentação

```txt
http://localhost:8080/docs
```

---

# Pré-requisitos

- Java 21+
- Maven
- PostgreSQL

---

# Configuração do Banco

Exemplo de configuração no `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/cursos
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# Como Executar

## Clonar repositório

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

---

## Entrar no projeto

```bash
cd seu-repositorio
```

---

## Executar aplicação

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```

---

# Exemplo de JSON

## Cadastro de Aluno

```json
{
  "nome": "Matheus Felipe",
  "email": "matheus@email.com",
  "idade": 21,
  "telefone": "45999999999"
}
```

---

## Cadastro de Curso

```json
{
  "nome": "Engenharia de Software",
  "cargaHoraria": 3200,
  "categoria": "Graduação",
  "ativo": true
}
```

---

## Cadastro de Matrícula

```json
{
  "dataMatricula": "2026-05-16",
  "status": "ATIVA",
  "alunoId": 1,
  "cursoId": 1
}
```

---

# Estrutura do Projeto

```txt
src/main/java
 └── edu/utfpr/cursos
      ├── controller
      ├── dto
      ├── model
      ├── repository
      └── config
```

---

# Autor

Matheus Felipe

