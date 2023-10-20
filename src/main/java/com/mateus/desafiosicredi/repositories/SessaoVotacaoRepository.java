package com.mateus.desafiosicredi.repositories;

import com.mateus.desafiosicredi.models.SessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoVotacaoRepository extends JpaRepository<SessaoVotacao, Long> {
}
