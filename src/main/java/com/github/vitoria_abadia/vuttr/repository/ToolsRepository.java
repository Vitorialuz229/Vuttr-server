package com.github.vitoria_abadia.vuttr.repository;


import com.github.vitoria_abadia.vuttr.model.ToolsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ToolsRepository extends JpaRepository<ToolsModel, UUID> {
//    public List<ToolsModel> busca();

//    ToolsModel findByTags(String tag);

//    List<ToolsModel> findAllBy();
//    List<TagsModel> findAllBy(int codigo);
}
