package com.mateus.desafiosicredi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessaoVotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Pauta pauta;

    private LocalDateTime inicio;

    private Long duracaoEmSegundos;

    private Duration duracao;

    public SessaoVotacao( Pauta pauta, Duration duracao) {
        this.pauta = pauta;
        this.inicio = LocalDateTime.now();
        this.duracao = duracao;
    }

    public LocalDateTime getFim(){
        return inicio.plus(duracao);
    }
}
