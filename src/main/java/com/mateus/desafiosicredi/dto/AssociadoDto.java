package com.mateus.desafiosicredi.dto;

import com.mateus.desafiosicredi.models.Voto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AssociadoDto {

    private Long id;
    @NotBlank(message = "campo obrigatorio")
    private String nome;

    private List<Voto> votos = new ArrayList<>();

}
