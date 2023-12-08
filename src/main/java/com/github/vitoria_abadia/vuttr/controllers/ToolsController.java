package com.github.vitoria_abadia.vuttr.controllers;

import com.github.vitoria_abadia.vuttr.dtos.ToolsDTO;
import com.github.vitoria_abadia.vuttr.model.ToolsModel;
import com.github.vitoria_abadia.vuttr.repository.ToolsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/*Essa anotação indica que a classe é um controlador Spring MVC que trata requisições HTTP.
A classe será escaneada automaticamente pelo Spring e suas rotas serão configuradas.*/
@RestController
public class ToolsController {
    /*Realiza a injeção de dependência do 'ToolsRepository', que é uma interface Spring Data JPA
     para operações de banco de dados relacionadas à entidade 'ToolsModel'*/
    @Autowired
    private ToolsRepository toolsRepository;

    /*Um método que responde a requisições GET para o endpoint raiz. Ele chama o método 'findAll'
    do 'toolsRepository' para obter todas as ferramentas no banco de dados e retorna uma resposta HTTP
    com lista de ferramentas e o status 200 (OK)*/
    @GetMapping
    public ResponseEntity<List<ToolsModel>> getAll() {
        final var list = toolsRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    /*@GetMapping("/{id}"): Esta anotação do Spring indica que o método getById responderá a requisições HTTP
    do tipo GET no endpoint "/{id}". Isso significa que, quando você faz uma requisição GET para um URL como
    "/algum-valor-aqui", o método getById será chamado, e o valor fornecido após a barra será atribuído ao
    parâmetro id.*/

    public ResponseEntity<Object> getById(@PathVariable(name = "id") UUID id){
   /*Ele declara que o método e retorna um objeto ResponseEntity<Object>.
    O @PathVariable(name = "id") indica que o parâmetro id é extraído da variável de caminho (path variable)
    na URL.*/
        Optional<ToolsModel> toolsFounded = this.toolsRepository.findById(id);
        /*Obtém uma instância de ToolsModel do repositório com base no ID fornecido. O retorno é encapsulado
        em um Optional, que é uma abordagem para lidar com possíveis valores nulos. */
        if(toolsFounded.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tool not founded");
        }
        /*if(toolsFounded.isEmpty()) { return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tool not founded");
        }: Verifica se o Optional está vazio. Se estiver vazio, significa que a ferramenta com o ID fornecido não
        foi encontrada, e o método retorna uma resposta HTTP 404 (NOT_FOUND) com a mensagem "Tool not founded".*/
        final var toolsModel = toolsFounded.get();
        /*Se a ferramenta foi encontrada, o método prossegue e obtém a instância real de ToolsModel do Optional.*/
        return ResponseEntity.status(HttpStatus.OK).body(toolsModel);
    }   /*ResponseEntity.status(HttpStatus.OK).body(toolsModel);: Retorna uma resposta HTTP 200 (OK) contendo a
        instância de ToolsModel como corpo da resposta. Isso significa que a ferramenta foi encontrada com
        sucesso, e a resposta contém os detalhes da ferramenta.*/

    /*Esse método responde a requisições POST para o endpoint raiz. Ele recebe dados no corpo da requisição
    no formato JSON (usando a anotação @RequestBody) e cria uma nova instância de Tools com base nos dados recebidos.
    Em seguida, retorna uma resposta HTTP com a ferramenta recém-criada e o status 201 (Created).*/
    @PostMapping
    public ResponseEntity<ToolsModel> create(@RequestBody ToolsDTO toolsDTO) {
        final var tools = new ToolsModel(toolsDTO);
        final var toolsModel = this.toolsRepository.save(tools);

        return ResponseEntity.status(HttpStatus.CREATED).body(toolsModel);
    }

    @PutMapping("/{id}")
    /*@PutMapping("/{id}"): Esta anotação do Spring indica que o método updateTool responderá a requisições HTTP do
    tipo PUT no endpoint "/{id}". Isso significa que, quando você faz uma requisição PUT para um URL como "/algum-valor-aqui",
    o método updateTool será chamado, e o valor fornecido após a barra será atribuído ao parâmetro id.*/
    public ResponseEntity<Object> updateTool(@RequestBody ToolsDTO toolsDTO, @PathVariable(value = "id") UUID id) {
        /*Ele declara que o método retorna um objeto ResponseEntity<Object>. O @RequestBody ToolsDTO toolsDTO indica que
         os dados da requisição (JSON, geralmente) serão convertidos para um objeto ToolsDTO.O @PathVariable(value = "id")
         UUID id indica que o parâmetro id é extraído da variável de caminho (path variable) na URL.*/
        Optional<ToolsModel> tools = toolsRepository.findById(id);

        if(tools.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tool not found");
        }
        /*Verifica se o Optional está vazio. Se estiver vazio, significa que a ferramenta com o ID fornecido não foi
        encontrada, e o método retorna uma resposta HTTP 404 (NOT_FOUND) com a mensagem "Tool not found".*/
        var toolModel = tools.get();
        /*Se a ferramenta foi encontrada, o método prossegue e obtém a instância real de ToolsModel do Optional.*/
        final var newTool = new ToolsModel(toolsDTO);
        /*: Cria uma nova instância de ToolsModel a partir dos dados fornecidos no corpo da requisição (toolsDTO).*/

        BeanUtils.copyProperties(toolModel, newTool);
        /*Copia as propriedades da instância original (toolModel) para a nova instância (newTool). Isso atualiza as
        propriedades da ferramenta existente com as informações fornecidas no corpo da requisição.*/
        this.toolsRepository.save(toolModel);
        /*Salva as alterações na instância original no repositório.*/

        return ResponseEntity.status(HttpStatus.OK).body(toolsRepository.save(newTool));
    }   /*Retorna uma resposta HTTP 200 (OK) contendo a instância de ToolsModel atualizada. A nova instância (newTool)
        é salva no repositório antes de ser retornada.*/

    @DeleteMapping("/{id}")
    /*Esta anotação do Spring indica que o método deleteTools responderá a requisições HTTP do tipo DELETE no endpoint
    "/{id}". Isso significa que, quando você faz uma requisição DELETE para um URL como "/algum-valor-aqui", o método
    deleteTools será chamado, e o valor fornecido após a barra será atribuído ao parâmetro id.*/
    public ResponseEntity<Object> deleteTools(@PathVariable(value = "id") UUID id) {
        /*Ele declara que o método retorna um objeto ResponseEntity<Object>. O @PathVariable(value = "id") UUID id indica
        que o parâmetro id é extraído da variável de caminho (path variable) na URL.*/
        Optional<ToolsModel> toolsFounded = this.toolsRepository.findById(id);
        /*Obtém uma instância de ToolsModel do repositório com base no ID fornecido.
        O retorno é encapsulado em um Optional, que é uma abordagem para lidar com possíveis valores nulos.*/

        if(toolsFounded.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tool not founded");
        }
        /*Verifica se o Optional está vazio. Se estiver vazio, significa que a ferramenta com o ID fornecido não foi
        encontrada, e o método retorna uma resposta HTTP 404 (NOT_FOUND) com a mensagem "Tool not found".*/
        final var tools = toolsFounded.get();
        /*Se a ferramenta foi encontrada, o método prossegue e obtém a instância real de ToolsModel do Optional.*/

        this.toolsRepository.delete(tools);
        /*Exclui a instância da ferramenta do repositório. Isso efetivamente remove a ferramenta do banco de dados.*/

        return ResponseEntity.status(HttpStatus.OK).build();
    }   /*Retorna uma resposta HTTP 200 (OK) indicando que a operação de exclusão foi bem-sucedida. O corpo da resposta
        está vazio (build()), pois não há necessidade de retornar dados específicos após a exclusão.*/
}
