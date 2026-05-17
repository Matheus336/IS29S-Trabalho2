# API Cursos UTFPR



API REST desenvolvida com Spring Boot para a matéria IS29S da Universidade Tecnológica Federal do Paraná - DV

O intuito é realizar o gerenciamento de cursos, que deve possuir as seguintes entidades:

- Alunos
- Cursos
- Matrículas

---

# Funcionalidades


## Alunos

- Cadastro de alunos
- Consulta de alunos por ID
- Listagem completa de alunos com paginação
- Atualização de dados
- Remoção de alunos

## Cursos

- Cadastro de cursos
- Consulta de cursos por ID
- Listagem completa de cursos com paginação
- Atualização de dados
- Remoção de cursos

## Matrículas

- Cadastro de matrículas
- Consulta de matriculas por ID
- Listagem completa de matriculas com paginação
- Atualização de dados
- Remoção de matrículas
- Associação entre aluno e curso

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
| GET | `/aluno` | Lista completa de alunos |
| PUT | `/aluno/{id}` | Atualiza um aluno |
| DELETE | `/aluno/{id}` | Remove um aluno |

---

## Endpoints de Cursos

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/curso` | Cadastra um curso |
| GET | `/curso/{id}` | Busca curso por ID |
| GET | `/curso` | Lista completa de cursos |
| PUT | `/curso/{id}` | Atualiza um curso |
| DELETE | `/curso/{id}` | Remove um curso |

---

## Endpoints de Matrículas

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/matricula` | Cadastra uma matrícula |
| GET | `/matricula/{id}` | Busca matrícula por ID |
| GET | `/matricula` | Lista completa de matrículas |
| PUT | `/matricula/{id}` | Atualiza uma matrícula |
| DELETE | `/matricula/{id}` | Remove uma matrícula |

---

# Paginação

Os endpoints de listagem completa suportam paginação automática utilizando Spring Pageable.

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

# Pré-requisitos

- Java 21+
- Maven

---

# Como Executar

## Clonar repositório

```bash
git clone https://github.com/Matheus336/IS29S-Trabalho2.git
```

---

## Entrar no projeto

```bash
cd IS29S-Trabalho2
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

# Documentação da API

Adicionalmente, foi adicionado ao projeto as dependências necessárias para gerar a documentação da API no Swagger e no Scalar

## Acessar documentação


- Swagger
```txt
http://localhost:8080/swagger-ui/index.html
```
- Scalar
```txt
http://localhost:8080/docs
```

Em ambas é possível baixar o json para exportar os endpoints para execução no software de sua preferência (Postman, Insomnia, Bruno)

---

# Autor

Matheus Felipe de Aguiar

E-mails: 

```txt
~$ maguiar@alunos.utfpr.edu.br
# matheusfelipem336@gmail.com
```

---
