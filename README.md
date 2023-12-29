<h1 align="center"> Very Useful Tools to Remember - Back-end</h1>

🧐 *ABOUT THE PROJECT*

Your task is to build an API and database for the VUTTR (Very Useful Tools to Remember) application. The application is a simple repository to manage tools with their respective names,
links, description, and tags.

🧰 *TECHNOLOGIES USED*

* Java 17 
* Spring Boot
* Spring Data JPA
* Lombok
* Database h2
* Postman
* GitKraten
* Intellij IDEA
---
💻 *REQUISITOS BACK-END*

* The API should respond on port 3000
* There should be a route to list all registered tools (GET /tools).
* It should be possible to filter tools using a tag search (GET /tools?tag=node).
* There must be a route to register a new tool (POST /tools) with response Status: 201 Created.
* User should be able to remove a tool by ID (DELETE /tools/:id) with Status response: 200 OK.

🚩 *HOW TO RUN THE PROJECT*

<h6>Prerequisites: </h6>
Java 17
Postman

<h5>Clone repository</h5>
git clone https://github.com/vitoria-abadia/vuttr-server.git

<h5>Execute the project</h5>
./mvnw spring-boot:run

# Endpoints

1. Get All Tools 
   Endpoint: GET /
   Description: Returns a list containing all available tools.
   Success Response (200): List of ToolsResponseDTO objects.
   Example Usage:
   GET http://localhost:3000/
  
2. Get Tool by ID
   Endpoint: GET /{id}
   Description: Returns details of a tool based on the provided ID.
   Path Parameters: id (UUID) - ID of the desired tool.
   Success Response (200): ToolsResponseDTO object.
   Example Usage:
   GET http://localhost:3000/123e4567-e89b-12d3-a456-426614174001
  
3. Get Tools by Tag
   Endpoint: GET /tag/{tag}
   Description: Returns a list of tools filtered by a specific tag.
   Path Parameters: tag (String) - Tag by which tools will be filtered.
   Success Response (200): List of ToolsResponseDTO objects.
   Example Usage:
   GET http://localhost:3000/tag/technology
  
4. Create a New Tool
   Endpoint: POST /
   Description: Creates a new tool based on the provided data.
   Request Body: ToolsRequestDTO object.
   Success Response (201): ToolsResponseDTO object.
   Example Usage:
   POST -H "Content-Type: application/json" -d '{"name":"New Tool","description":"Tool Description","link":"http://newtool.com","tags":["tag1","tag2"]}' http://localhost:3000/

5. Delete Tool by ID
   Endpoint: DELETE /{id}
   Description: Deletes the tool corresponding to the provided ID.
   Path Parameters: id (UUID) - ID of the tool to be deleted.
   Success Response (200): Message indicating that the tool has been deleted successfully.
   Example Usage:
   DELETE http://localhost:3000/123e4567-e89b-12d3-a456-42
<br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
<h1 align="center"> Ferramentas muito úteis para lembrar - Back-end</h1>

🧐 *SOBRE*

Sua tarefa é construir uma API e banco de dados para a aplicação VUTTR (Very Useful Tools to Remember). A aplicação é um simples repositório para gerenciar ferramentas com seus respectivos nomes, links, descrição e tags.

🧰 *TECNOLOGIAS UTILIZADAS*
* Java 17
* Spring Data JPA
* Lombok
* Database h2
* Postman
* GitKraten
* Intellij IDEA

💻 *REQUISITOS BACK-END*

* A API deve responder na porta 3000
* Deve haver uma rota para listar todas as ferramentas cadastradas (GET /tools).
* Deve ser possível filtrar ferramentas utilizando uma busca por tag (GET /tools?tag=node).
* Deve haver uma rota para cadastrar uma nova ferramenta (POST /tools) com resposta Status: 201 Created. 
* O usuário deve poder remover uma ferramenta por ID (DELETE /tools/:id) com resposta Status: 200 OK.

🚩 *COMO EXECUTAR O PROJETO*

<h4>Pré-requisitos: </h4>
Java 17
Postman

<h4>Clonar repositório</h4>
git clone https://github.com/vitoria-abadia/vuttr-server.git

<h4>Executar o projeto</h4>
./mvnw spring-boot:run

*Endpoints*

1. Obter Todas as Ferramentas
   Endpoint: GET /
   Descrição: Retorna uma lista contendo todas as ferramentas disponíveis.
   Resposta de Sucesso (200): Lista de objetos ToolsResponseDTO.
   Exemplo de Uso:
   GET http://localhost:3000/

2. Obter Ferramenta por ID
   Endpoint: GET /{id}
   Descrição: Retorna os detalhes de uma ferramenta com base no ID fornecido.
   Parâmetros de Caminho: id (UUID) - ID da ferramenta desejada.
   Resposta de Sucesso (200): Objeto ToolsResponseDTO.
   Exemplo de Uso:
   GET http://localhost:3000/123e4567-e89b-12d3-a456-426614174001

3. Obter Ferramentas por Tag
   Endpoint: GET /tag/{tag}
   Descrição: Retorna uma lista de ferramentas filtradas por uma tag específica.
   Parâmetros de Caminho: tag (String) - Tag pela qual as ferramentas serão filtradas.
   Resposta de Sucesso (200): Lista de objetos ToolsResponseDTO.
   Exemplo de Uso:
   GET http://localhost:3000/tag/tecnologia

4. Criar uma Nova Ferramenta
   Endpoint: POST /
   Descrição: Cria uma nova ferramenta com base nos dados fornecidos.
   Corpo da Requisição: Objeto ToolsRequestDTO.
   Resposta de Sucesso (201): Objeto ToolsResponseDTO.
   Exemplo de Uso:
   POST -H "Content-Type: application/json" -d '{"name":"Ferramenta Nova","description":"Descrição da Ferramenta","link":"http://ferramentanova.com","tags":["tag1","tag2"]}' http://localhost:3000/

5. Deletar Ferramenta por ID
   Endpoint: DELETE /{id}
   Descrição: Deleta a ferramenta correspondente ao ID fornecido.
   Parâmetros de Caminho: id (UUID) - ID da ferramenta a ser deletada.
   Resposta de Sucesso (200): Mensagem indicando que a ferramenta foi deletada com sucesso.
   Exemplo de Uso:
   DELETE http://localhost:3000/123e4567-e89b-12d3-a456-42
  