package com.mateus.desafiosicredi.services;

import com.mateus.desafiosicredi.dto.AssociadoDto;
import com.mateus.desafiosicredi.models.Associado;
import com.mateus.desafiosicredi.repositories.AssociadoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssociadoService {

    private final AssociadoRepository associadoRepository;
    private final ModelMapper modelMapper;

    public AssociadoDto criarAssociado(AssociadoDto associadoDto) {
        Associado associado = modelMapper.map(associadoDto,Associado.class);
        associado = associadoRepository.save(associado);
        return modelMapper.map(associado, AssociadoDto.class);
    }

    public List<AssociadoDto> listarAssociados(){
        List<Associado> associadoList = associadoRepository.findAll();

        return associadoList.stream()
                .map(associado -> modelMapper.map(associado, AssociadoDto.class))
                .collect(Collectors.toList());
    }


}
