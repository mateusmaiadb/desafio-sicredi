package com.mateus.desafiosicredi.services;

import com.mateus.desafiosicredi.dto.SessaoDto;
import com.mateus.desafiosicredi.models.SessaoVotacao;
import com.mateus.desafiosicredi.repositories.SessaoVotacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SessaoServiceTest {

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @InjectMocks
    private SessaoService sessaoService;

    private SessaoVotacao sessaoVotacao1;

    private SessaoDto sessaoDto1;

    private SessaoVotacao sessaoVotacao2;

    private SessaoDto sessaoDto2;



    @BeforeEach
    void setUp() {
        sessaoVotacao1 = new SessaoVotacao();
        sessaoVotacao1.setId(1L);

        sessaoDto1 = new SessaoDto();
        sessaoDto1.setId(1L);

        sessaoVotacao2 = new SessaoVotacao();
        sessaoVotacao2.setId(2L);

        sessaoDto2 = new SessaoDto();
        sessaoDto2.setId(2L);

    }

    @Test
    void criaSessao() {

        when(sessaoVotacaoRepository.save(any())).thenReturn(sessaoVotacao1);
        given(modelMapper.map(sessaoDto1, SessaoVotacao.class)).willReturn(sessaoVotacao1);
        given(modelMapper.map(sessaoVotacao1, SessaoDto.class)).willReturn(sessaoDto1);

        var sessaoSalva = sessaoService.criaSessao(sessaoDto1);

        verify(sessaoVotacaoRepository, times(1)).save(any());
        assertNotNull(sessaoSalva);

    }

    @Test
    @DisplayName("Retorna todas as Pautas cadastradas")
    public void testListarTodasAsPautas() {
        List<SessaoVotacao> votacaoList = Arrays.asList(sessaoVotacao1,sessaoVotacao2);
        when(sessaoVotacaoRepository.findAll()).thenReturn(votacaoList);

        List<SessaoDto> sessaoDtos = sessaoService.listarSessoes();

        assertEquals(2,votacaoList.size());
        assertNotNull(sessaoDtos);
    }
}