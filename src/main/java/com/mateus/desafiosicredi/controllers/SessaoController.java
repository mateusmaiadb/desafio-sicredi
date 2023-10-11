package com.mateus.desafiosicredi.controllers;


import com.mateus.desafiosicredi.models.SessaoVotacao;
import com.mateus.desafiosicredi.repositories.SessaoVotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sessoes")
public class SessaoController {

    @Autowired
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @PostMapping
    public ResponseEntity<SessaoVotacao> criarSessao(@RequestBody SessaoVotacao sessaoVotacao){
        return ResponseEntity.status(HttpStatus.CREATED).body(sessaoVotacaoRepository.save(sessaoVotacao));
    }

}
