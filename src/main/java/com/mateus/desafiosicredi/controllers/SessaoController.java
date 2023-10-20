package com.mateus.desafiosicredi.controllers;


import com.mateus.desafiosicredi.dto.SessaoDto;
import com.mateus.desafiosicredi.services.SessaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("sessoes")
public class SessaoController {


    private final SessaoService sessaoService;

    @PostMapping
    public ResponseEntity<SessaoDto> criarSessao(@RequestBody @Valid SessaoDto sessaoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(sessaoService.criaSessao(sessaoDto));
    }

    @GetMapping
    public ResponseEntity<List<SessaoDto>> listarSessoes(){
        List<SessaoDto>  sessaoDtos = sessaoService.listarSessoes();
        return ResponseEntity.ok(sessaoDtos);
    }

}
