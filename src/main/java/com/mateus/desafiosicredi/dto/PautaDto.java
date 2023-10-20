package com.mateus.desafiosicredi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PautaDto {

    private Long id;
    @NotBlank(message = "Esse campo nao pode ser em branco")
    private String titulo;
    private String descricao;
}
