package com.mateus.desafiosicredi.services;

import com.mateus.desafiosicredi.dto.VotoDto;
import com.mateus.desafiosicredi.models.Voto;
import com.mateus.desafiosicredi.repositories.VotoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VotoService {

    private final VotoRepository votoRepository;

    private final ModelMapper modelMapper;

    public VotoDto criarVoto(VotoDto votoDto) {
        Voto voto = modelMapper.map(votoDto, Voto.class);
        voto = votoRepository.save(voto);
        return modelMapper.map(voto, VotoDto.class);
    }

    public List<VotoDto> listarVotos(){
        List<Voto> votoList = votoRepository.findAll();

        return votoList.stream()
                .map(votos -> modelMapper.map(votos, VotoDto.class))
                .collect(Collectors.toList());
    }


}
