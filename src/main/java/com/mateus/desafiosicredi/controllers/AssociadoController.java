package com.mateus.desafiosicredi.controllers;

import com.mateus.desafiosicredi.dto.AssociadoDto;
import com.mateus.desafiosicredi.services.AssociadoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("associados")
public class AssociadoController {


    private final AssociadoService associadoService;

    @PostMapping
    public ResponseEntity<AssociadoDto> criarAssociado(@RequestBody @Valid AssociadoDto associadoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(associadoService.criarAssociado(associadoDto));
    }

    @GetMapping
    public ResponseEntity<List<AssociadoDto>> listarAssociados(){
        List<AssociadoDto> associadoDtos = associadoService.listarAssociados();
        return ResponseEntity.ok(associadoDtos);
    }
}
