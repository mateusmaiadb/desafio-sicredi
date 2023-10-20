package com.mateus.desafiosicredi.services;

import com.mateus.desafiosicredi.dto.SessaoDto;
import com.mateus.desafiosicredi.models.SessaoVotacao;
import com.mateus.desafiosicredi.repositories.SessaoVotacaoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SessaoService {

    private final SessaoVotacaoRepository sessaoVotacaoRepository;

    private final ModelMapper modelMapper;


    public SessaoDto criaSessao(SessaoDto sessaoDto) {
        LocalDateTime inicio = LocalDateTime.now();
        sessaoDto.setInicio(inicio);
        SessaoVotacao sessaoVotacao = modelMapper.map(sessaoDto, SessaoVotacao.class);
        sessaoVotacao = sessaoVotacaoRepository.save(sessaoVotacao);

        if (sessaoDto.getDuracao() == null){
            sessaoDto.setDuracao(Duration.ofMinutes(1));
        }

        return modelMapper.map(sessaoVotacao, SessaoDto.class);
    }



    public List<SessaoDto> listarSessoes(){
        List<SessaoVotacao> sessaoVotacaoList = sessaoVotacaoRepository.findAll();

        return sessaoVotacaoList.stream()
                .map(sessaoVotacao -> modelMapper.map(sessaoVotacao, SessaoDto.class))
                .collect(Collectors.toList());
    }


}
