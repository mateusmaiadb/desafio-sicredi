package com.mateus.desafiosicredi.services;

import com.mateus.desafiosicredi.dto.PautaDto;
import com.mateus.desafiosicredi.models.Pauta;
import com.mateus.desafiosicredi.repositories.PautaRepository;
import com.mateus.desafiosicredi.repositories.SessaoVotacaoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PautaService {


    private final ModelMapper modelMapper;

    private final PautaRepository pautaRepository;
    private  final SessaoVotacaoRepository sessaoVotacaoRepository;

    public PautaDto criarPauta(PautaDto pautaDto){
        Pauta pauta = modelMapper.map(pautaDto, Pauta.class);
        pauta = pautaRepository.save(pauta);
        return modelMapper.map(pauta, PautaDto.class);
    }


    public List<PautaDto> listarPautas(){
        List<Pauta> pautaList = pautaRepository.findAll();

       return pautaList.stream()
               .map(pauta -> modelMapper.map(pauta, PautaDto.class))
               .collect(Collectors.toList());
    }

}
