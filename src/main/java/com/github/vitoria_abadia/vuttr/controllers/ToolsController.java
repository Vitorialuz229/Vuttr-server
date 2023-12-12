package com.github.vitoria_abadia.vuttr.controllers;

import com.github.vitoria_abadia.vuttr.dtos.ToolsDTO;
import com.github.vitoria_abadia.vuttr.model.ToolsModel;
import com.github.vitoria_abadia.vuttr.repository.ToolsRepository;
import com.github.vitoria_abadia.vuttr.services.ToolsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Controlador Spring MVC que lida com requisições relacionadas a ferramentas (Tools).
 */
@RestController
public class ToolsController {

    @Autowired
    private ToolsRepository toolsRepository;
    private final ToolsService toolsService;
    private List<ToolsDTO> convertToDTOList(List<ToolsModel>toolsModelList){
        return null;
    }
    /**
     * Construtor que realiza a injeção de dependência do serviço ToolsService.
     *
     * @param toolsService O serviço ToolsService injetado.
     */
    public ToolsController(ToolsService toolsService) {
        this.toolsService = toolsService;
    }

    /**
     * Responde a requisições GET para o endpoint raiz, retornando todas as ferramentas no banco de dados.
     *
     * @return Uma ResponseEntity contendo a lista de ferramentas e o status da resposta.
     */
    @GetMapping
    public ResponseEntity<List<ToolsModel>> getAll() {
        final var list = toolsRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    /**
     * Responde a requisições GET para o endpoint "/{id}", retornando uma ferramenta com o ID especificado.
     *
     * @param id O ID da ferramenta a ser recuperada.
     * @return Uma ResponseEntity contendo a ferramenta encontrada e o status da resposta.
     */
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

    /**
     * Responde a requisições GET para o endpoint "/list", retornando todas as ferramentas no formato de ToolsResponse.
     *
     * @return Uma ResponseEntity contendo a lista de ToolsResponse e o status da resposta.
     */
    @GetMapping("/list")
    public ResponseEntity<List<ToolsDTO>> listAll() {
        List<ToolsDTO> toolsDTOSList = convertToDTOList(toolsService.listAll());
        return ResponseEntity.ok(toolsDTOSList);
    }

    /**
     * Responde a requisições GET para o endpoint "/tag", retornando ferramentas com uma tag específica.
     *
     * @param tag A tag pela qual as ferramentas devem ser filtradas.
     * @return Uma ResponseEntity contendo a lista de ToolsResponse e o status da resposta.
     */
    @GetMapping("/tag")
    public ResponseEntity<List<ToolsDTO>> findByTag(@RequestParam String tag) {
        List<ToolsDTO>toolsDTOSList = convertToDTOList(toolsService.findByTag(tag));
        return ResponseEntity.ok(toolsDTOSList);
    }
    /**
     * Cria uma nova ferramenta com base nos dados fornecidos no corpo da requisição.
     *
     * @param toolsDTO Um objeto DTO (Data Transfer Object) contendo os dados da nova ferramenta.
     * @return Uma ResponseEntity contendo a resposta da criação, incluindo a ferramenta recém-criada e o status HTTP.
     */
    @PostMapping
    public ResponseEntity<ToolsModel> create(@RequestBody ToolsDTO toolsDTO) {
        // Cria uma nova instância de ToolsModel com base nos dados fornecidos no DTO.
        final var tools = new ToolsModel(toolsDTO);

        // Salva a nova ferramenta no repositório.
        final var toolsModel = this.toolsRepository.save(tools);
        // Retorna uma resposta 201 (CREATED) com a ferramenta recém-criada no corpo da resposta.
        return ResponseEntity.status(HttpStatus.CREATED).body(toolsModel);
    }

    /**
     * Atualiza uma ferramenta existente com base nos dados fornecidos.
     *
     * @param toolsDTO Um objeto DTO (Data Transfer Object) contendo os dados atualizados da ferramenta.
     * @param id O ID da ferramenta a ser atualizada.
     * @return Uma ResponseEntity contendo a resposta da atualização, incluindo a ferramenta atualizada e o status HTTP.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTool(@RequestBody ToolsDTO toolsDTO, @PathVariable(value = "id") UUID id) {
        // Obtém a ferramenta atual do repositório com base no ID fornecido.
        Optional<ToolsModel> tools = toolsRepository.findById(id);
        // Verifica se a ferramenta foi encontrada.
        if(tools.isEmpty()){
            // Retorna uma resposta 404 (NOT_FOUND) se a ferramenta não foi encontrada.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tool not found");
        }
        // Obtém a instância atual de ToolsModel do Optional.
        var toolModel = tools.get();
        // Cria uma nova instância de ToolsModel com base nos dados fornecidos no DTO.
        final var newTool = new ToolsModel(toolsDTO);
        // Copia as propriedades da ferramenta atual para a nova ferramenta.
        BeanUtils.copyProperties(toolModel, newTool);
        // Salva as alterações na ferramenta atual no repositório.
        this.toolsRepository.save(toolModel);
        // Retorna uma resposta 200 (OK) com a ferramenta atualizada no corpo da resposta.
        return ResponseEntity.status(HttpStatus.OK).body(toolsRepository.save(newTool));
    }

    /**
     * Responde a requisições DELETE para o endpoint "/{id}", excluindo uma ferramenta com base no ID fornecido.
     *
     * @param id O ID da ferramenta a ser excluída.
     * @return Uma ResponseEntity contendo o status da resposta.
     */
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
