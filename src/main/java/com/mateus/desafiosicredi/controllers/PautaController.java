package com.mateus.desafiosicredi.controllers;

import com.mateus.desafiosicredi.dto.PautaDto;
import com.mateus.desafiosicredi.services.PautaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("pautas")
public class PautaController {

    private final PautaService pautaService;

    @PostMapping
    public ResponseEntity<PautaDto> criaPauta(@RequestBody @Valid PautaDto pautaDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pautaService.criarPauta(pautaDto));
    }

    @GetMapping
    public ResponseEntity<List<PautaDto>> listarPautas(){
        List<PautaDto> pautaDtos = pautaService.listarPautas();
        return ResponseEntity.ok(pautaDtos);
    }

}
