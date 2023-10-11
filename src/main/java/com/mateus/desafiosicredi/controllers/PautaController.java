package com.mateus.desafiosicredi.controllers;

import com.mateus.desafiosicredi.models.Pauta;
import com.mateus.desafiosicredi.repositories.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pautas")
public class PautaController {

    @Autowired
    private PautaRepository pautaRepository;

    @PostMapping
    public ResponseEntity<Pauta> criaPauta(@RequestBody Pauta pauta){
        return ResponseEntity.status(HttpStatus.CREATED).body(pautaRepository.save(pauta));
    }

}
