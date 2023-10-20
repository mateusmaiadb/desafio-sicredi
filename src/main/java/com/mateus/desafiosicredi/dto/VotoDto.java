package com.mateus.desafiosicredi.dto;

import com.mateus.desafiosicredi.models.TipoVoto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VotoDto {

    private Long id;
    private AssociadoDto associado;
    private SessaoDto sessaoVotacao;
    @NotBlank(message = "voto nao pode ser vazio")
    private TipoVoto tipoVoto;
}
