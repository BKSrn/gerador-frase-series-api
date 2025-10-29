# 🎬 Gerador de Frases de Séries - API

API REST desenvolvida com Spring Boot que retorna frases aleatórias de séries de TV, incluindo informações sobre o título da série, personagem, frase e poster.

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Tecnologias](#tecnologias)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Como Usar](#como-usar)
- [Endpoints](#endpoints)
- [Exemplos de Uso](#exemplos-de-uso)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Banco de Dados](#banco-de-dados)
- [Frontend](#frontend)

## 📖 Sobre o Projeto

O **Gerador de Frases de Séries** é uma API que fornece frases icônicas de séries de TV de forma aleatória. Perfeito para criar aplicações de citações, widgets ou jogos de adivinhação de séries.

### 🎯 Como funciona?

1. A API busca uma frase aleatória do banco de dados
2. Retorna informações completas: título da série, frase, personagem e URL do poster
3. Cada requisição retorna uma frase diferente (aleatória)

## ✨ Funcionalidades

- ✅ Retorna frases aleatórias de séries
- ✅ Inclui informações do personagem que disse a frase
- ✅ Fornece URL do poster da série
- ✅ Configuração CORS para integração com frontend
- ✅ Queries otimizadas com PostgreSQL

## 🛠️ Tecnologias

- **Java 21**
- **Spring Boot 3.5.7**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**
- **Spring DevTools** (hot reload em desenvolvimento)

## 📦 Pré-requisitos

Certifique-se de ter instalado:

- [Java JDK 21](https://www.oracle.com/java/technologies/downloads/) ou superior
- [Maven 3.6+](https://maven.apache.org/download.cgi)
- [PostgreSQL 12+](https://www.postgresql.org/download/)
- [Git](https://git-scm.com/) (opcional)

## 🚀 Instalação

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/gerador-frase-series-api.git
cd gerador-frase-series-api
```

### 2. Compile o projeto

```bash
./mvnw clean install
```

## ⚙️ Configuração

### 1. Configurar o Banco de Dados

**Crie o banco de dados PostgreSQL:**

```sql
CREATE DATABASE desafio_db;
```

### 2. Configurar Variáveis de Ambiente

A aplicação utiliza variáveis de ambiente para conexão com o banco:

#### Linux/Mac:
```bash
export DB_HOST=localhost:5432
export DB_USER=seu_usuario
export DB_PASSWORD=sua_senha
```

#### Windows (CMD):
```cmd
set DB_HOST=localhost:5432
set DB_USER=seu_usuario
set DB_PASSWORD=sua_senha
```

#### Windows (PowerShell):
```powershell
$env:DB_HOST="localhost:5432"
$env:DB_USER="seu_usuario"
$env:DB_PASSWORD="sua_senha"
```

### 3. Popular o Banco de Dados

Execute o seguinte script SQL para criar e popular a tabela:

```sql
-- Criar tabela
CREATE TABLE frases (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    frase TEXT NOT NULL,
    personagem VARCHAR(255) NOT NULL,
    poster VARCHAR(500)
);

-- Inserir frases de exemplo
INSERT INTO frases (titulo, frase, personagem, poster) VALUES
('Breaking Bad', 'I am the one who knocks!', 'Walter White', 'https://example.com/breaking-bad.jpg'),
('Game of Thrones', 'Winter is coming.', 'Ned Stark', 'https://example.com/got.jpg'),
('Friends', 'We were on a break!', 'Ross Geller', 'https://example.com/friends.jpg'),
('The Office', 'That''s what she said.', 'Michael Scott', 'https://example.com/office.jpg'),
('Stranger Things', 'Friends don''t lie.', 'Eleven', 'https://example.com/stranger-things.jpg');
```

### 4. Configuração CORS

O CORS está configurado para aceitar requisições de `http://127.0.0.1:5500` (Live Server).

Para alterar as origens permitidas, edite o arquivo `CorsConfig.java`:

```java
.allowedOrigins("http://127.0.0.1:5500", "http://localhost:3000")
```

## ▶️ Como Usar

### Iniciar a aplicação

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em: **http://localhost:8080**

### Gerar JAR executável

```bash
./mvnw clean package
java -jar target/gerador-frase-series-api-0.0.1-SNAPSHOT.jar
```

## 🔗 Endpoints

### Base URL
```
http://localhost:8080
```

### Endpoint Disponível

| Método | Endpoint | Descrição | Retorno |
|--------|----------|-----------|---------|
| `GET` | `/series/frases` | Retorna uma frase aleatória de série | JSON |

## 📝 Exemplos de Uso

### 1. Buscar Frase Aleatória

**Request:**
```bash
GET /series/frases
```

**Response (200 OK):**
```json
{
  "id": 1,
  "titulo": "Breaking Bad",
  "frase": "I am the one who knocks!",
  "personagem": "Walter White",
  "poster": "https://example.com/breaking-bad.jpg"
}
```

### Usando cURL

```bash
curl http://localhost:8080/series/frases
```

### Usando JavaScript (Fetch API)

```javascript
fetch('http://localhost:8080/series/frases')
  .then(response => response.json())
  .then(data => {
    console.log(`${data.personagem} de ${data.titulo} disse:`);
    console.log(`"${data.frase}"`);
  })
  .catch(error => console.error('Erro:', error));
```

### Usando Axios

```javascript
axios.get('http://localhost:8080/series/frases')
  .then(response => {
    const { titulo, frase, personagem, poster } = response.data;
    console.log(`${personagem}: "${frase}"`);
  });
```

## 📂 Estrutura do Projeto

```
gerador-frase-series-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/gerador_frase_series_api/
│   │   │       ├── config/
│   │   │       │   └── CorsConfig.java           # Configuração CORS
│   │   │       ├── controller/
│   │   │       │   └── FraseController.java      # Endpoint REST
│   │   │       ├── model/
│   │   │       │   └── Frase.java                # Entidade JPA
│   │   │       ├── repository/
│   │   │       │   └── FraseRepository.java      # Repositório com query
│   │   │       ├── service/
│   │   │       │   └── FraseService.java         # Lógica de negócio
│   │   │       └── GeradorFraseSeriesApiApplication.java
│   │   └── resources/
│   │       └── application.properties            # Configurações
│   └── test/
│       └── java/
└── pom.xml
```

## 🗃️ Banco de Dados

### Modelo de Dados

#### Tabela: `frases`

| Campo | Tipo | Descrição | Obrigatório |
|-------|------|-----------|-------------|
| `id` | BIGSERIAL | ID único (PK) | Sim |
| `titulo` | VARCHAR(255) | Nome da série | Sim |
| `frase` | TEXT | Citação/frase | Sim |
| `personagem` | VARCHAR(255) | Quem disse a frase | Sim |
| `poster` | VARCHAR(500) | URL do poster | Não |

### Diagrama ER

```
┌─────────────────────────┐
│        frases           │
├─────────────────────────┤
│ id (PK)                 │
│ titulo                  │
│ frase                   │
│ personagem              │
│ poster                  │
└─────────────────────────┘
```

### Query Especial

A API utiliza uma query customizada com função `RANDOM()` do PostgreSQL:

```sql
SELECT f FROM Frase f ORDER BY RANDOM() LIMIT 1
```

## 🌐 Frontend

### Exemplo de Integração HTML + JavaScript

```html
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gerador de Frases de Séries</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 50px auto;
            text-align: center;
            padding: 20px;
        }
        .card {
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 20px;
            margin: 20px 0;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        button {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #0056b3;
        }
        .frase {
            font-size: 18px;
            font-style: italic;
            margin: 20px 0;
        }
        .personagem {
            font-weight: bold;
            color: #007bff;
        }
        img {
            max-width: 200px;
            margin-top: 20px;
            border-radius: 8px;
        }
    </style>
</head>
<body>
    <h1>🎬 Frases de Séries</h1>
    
    <div class="card">
        <div id="conteudo">
            <p>Clique no botão para gerar uma frase!</p>
        </div>
    </div>
    
    <button onclick="buscarFrase()">Gerar Nova Frase</button>

    <script>
        async function buscarFrase() {
            try {
                const response = await fetch('http://localhost:8080/series/frases');
                const data = await response.json();
                
                document.getElementById('conteudo').innerHTML = `
                    <h2>${data.titulo}</h2>
                    <p class="frase">"${data.frase}"</p>
                    <p class="personagem">- ${data.personagem}</p>
                    ${data.poster ? `<img src="${data.poster}" alt="${data.titulo}">` : ''}
                `;
            } catch (error) {
                console.error('Erro ao buscar frase:', error);
                alert('Erro ao buscar frase. Verifique se a API está rodando.');
            }
        }
    </script>
</body>
</html>
```

## 🧪 Testes

Execute os testes com:

```bash
./mvnw test
```

## 🔧 Desenvolvimento

### Hot Reload

O projeto inclui Spring DevTools para hot reload automático durante o desenvolvimento.

### Adicionar Novas Frases

Para adicionar novas frases, insira diretamente no banco:

```sql
INSERT INTO frases (titulo, frase, personagem, poster) 
VALUES ('Nome da Série', 'Frase icônica', 'Nome do Personagem', 'URL do poster');
```

## 🐛 Troubleshooting

### Erro de Conexão com Banco

**Problema:** `Could not open connection to database`

**Solução:**
- Verifique se o PostgreSQL está rodando
- Confirme as variáveis de ambiente (DB_HOST, DB_USER, DB_PASSWORD)
- Teste a conexão manualmente: `psql -U seu_usuario -d desafio_db`

### Erro CORS

**Problema:** `Access-Control-Allow-Origin error`

**Solução:**
- Adicione a origem do seu frontend em `CorsConfig.java`
- Verifique se a porta está correta (padrão: 5500 para Live Server)

### Nenhuma Frase Retornada

**Problema:** API retorna `null` ou erro

**Solução:**
- Verifique se há dados na tabela: `SELECT * FROM frases;`
- Popule o banco com o script SQL fornecido

## 🚀 Deploy

### Heroku

```bash
# Login no Heroku
heroku login

# Criar aplicação
heroku create gerador-frases-series

# Adicionar PostgreSQL
heroku addons:create heroku-postgresql:mini

# Deploy
git push heroku main
```

### Railway

1. Conecte seu repositório GitHub
2. Adicione PostgreSQL como serviço
3. Configure as variáveis de ambiente
4. Deploy automático

## 📄 Licença

Este projeto está sob a licença MIT.

## 👨‍💻 Autor

Desenvolvido com Spring Boot

---

## 📞 Contato

- GitHub: [@BKSrn](https://github.com/BKSrn)
- Email: bekist2006@gmail.com

---

**⭐ Se este projeto foi útil, considere dar uma estrela no GitHub!**

## 🎯 Exemplos de Séries Sugeridas

Para popular seu banco de dados, aqui estão algumas sugestões:

- Breaking Bad
- Game of Thrones
- Friends
- The Office
- Stranger Things
- The Crown
- Peaky Blinders
- Dark
- Money Heist (La Casa de Papel)
- The Mandalorian
- The Witcher
- Brooklyn Nine-Nine
- How I Met Your Mother
- The Big Bang Theory
- Sherlock