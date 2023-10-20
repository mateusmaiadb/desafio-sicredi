package com.mateus.desafiosicredi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
public class SessaoDto {

    @NotBlank(message = "Id nao pode ser nulo")
    private Long id;
    private PautaDto pauta;
    private LocalDateTime inicio;
    private Long duracaoEmSegundos;
    private Duration duracao;
}
