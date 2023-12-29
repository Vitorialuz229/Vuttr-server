package com.github.vitoria_abadia.vuttr.services;

import com.github.vitoria_abadia.vuttr.DTO.ToolsRequestDTO;
import com.github.vitoria_abadia.vuttr.DTO.ToolsResponseDTO;
import com.github.vitoria_abadia.vuttr.adapter.ToolsAdapter;
import com.github.vitoria_abadia.vuttr.model.ToolsModel;
import com.github.vitoria_abadia.vuttr.repository.ToolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Serviço de tools para utilização do repositório e regras de negócio.
 */
@Service
public class ToolsService {
    @Autowired
    private ToolsRepository toolsRepository;

    @Autowired
    private ToolsAdapter toolAdapter;
    /**
     * Obtém todas as ferramentas.
     *
     * @return Uma lista de DTOs de resposta das ferramentas.
     */
    public List<ToolsResponseDTO> listAll() {
        return toolsRepository.findAll()
                .stream()
                .map(toolAdapter::ToToolsDTO)
                .collect(Collectors.toList());
    }
    /**
     * Obtém uma ferramenta por ID.
     *
     * @param id O ID da ferramenta a ser obtida.
     * @return A ferramenta encontrada.
     * @throws RuntimeException Se a ferramenta não for encontrada.
     */
    public ToolsResponseDTO getById(UUID id){
        Optional<ToolsModel> toolFounded = this.toolsRepository.findById(id);

        if(toolFounded.isEmpty()){
            throw new RuntimeException("Ferramenta não encotrada");
        }
        final var tool = this.toolAdapter.ToToolsDTO(toolFounded.get());
        return tool;
    }
    /**
     * Obtém ferramentas por tag.
     *
     * @param tag A tag pela qual as ferramentas serão filtradas.
     * @return Uma lista de ferramentas encontradas pela tag.
     */
    public List<ToolsResponseDTO> findByTag(String tag) {
//        final var toolResponseList = this.listAll();
//        List<ToolsResponseDTO> newToolList = new ArrayList<ToolsResponseDTO>();
//
//        for (ToolsResponseDTO toolResponse : toolResponseList) {
//            if (tag.equals(toolResponse.getTags())) {
//                newToolList.add(toolResponse);
//            }
//        }
//
//        return newToolList;
        return this.toolsRepository.findAllByTags(tag);
    }
    /**
     * Cria uma nova ferramenta.
     *
     * @param toolRequest DTO contendo os dados da nova ferramenta.
     * @return A ferramenta recém-criada.
     */
    public ToolsResponseDTO create(ToolsRequestDTO toolRequest) {
        final var tool = this.toolAdapter.toTool(toolRequest);
        ToolsModel newTool = this.toolsRepository.save(tool);

        return this.toolAdapter.ToToolsDTO(newTool);
    }
    /**
     * Deleta uma ferramenta por ID.
     *
     * @param id O ID da ferramenta a ser deletada.
     * @throws RuntimeException Se a ferramenta não for encontrada.
     */
    public void delete(UUID id) {
        var tool = this.toolsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Non-found tool"));
        this.toolsRepository.delete((ToolsModel) tool);
    }
}