package com.mateus.desafiosicredi.repositories;

import com.mateus.desafiosicredi.models.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {
}
