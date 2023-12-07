package com.github.vitoria_abadia.vuttr.repository;


import com.github.vitoria_abadia.vuttr.model.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ToolsRepository extends JpaRepository<Tools, UUID> {

}
