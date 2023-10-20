package com.mateus.desafiosicredi.controllers;

import com.mateus.desafiosicredi.dto.VotoDto;
import com.mateus.desafiosicredi.services.VotoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("votos")
public class VotoController {


    private final VotoService votoService;

    @PostMapping
    public ResponseEntity<VotoDto> criaVoto(@RequestBody @Valid VotoDto votoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(votoService.criarVoto(votoDto));
    }

    @GetMapping
    public ResponseEntity<List<VotoDto>> listarTodosVotos(){
        List<VotoDto> votoDtoList = votoService.listarVotos();
        return ResponseEntity.ok(votoDtoList);
    }


}
