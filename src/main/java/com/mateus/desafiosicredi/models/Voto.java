package com.mateus.desafiosicredi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Voto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Associado associado;

    @ManyToOne
    private SessaoVotacao sessaoVotacao;

    private TipoVoto tipoVoto;

}
