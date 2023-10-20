package com.mateus.desafiosicredi.services;

import com.mateus.desafiosicredi.dto.AssociadoDto;
import com.mateus.desafiosicredi.dto.SessaoDto;
import com.mateus.desafiosicredi.dto.VotoDto;
import com.mateus.desafiosicredi.models.Associado;
import com.mateus.desafiosicredi.models.SessaoVotacao;
import com.mateus.desafiosicredi.models.TipoVoto;
import com.mateus.desafiosicredi.models.Voto;
import com.mateus.desafiosicredi.repositories.AssociadoRepository;
import com.mateus.desafiosicredi.repositories.VotoRepository;
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
class VotoServiceTest {

    @Mock
    private VotoRepository votoRepository;

    @Mock
    private AssociadoRepository associadoRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private AssociadoService associadoService;

    @InjectMocks
    private VotoService votoService;

    private Voto voto1;
    private VotoDto votoDto1;

    private Voto voto2;
    private VotoDto votoDto2;
    private Associado associado;
    private AssociadoDto associadoDto;
    private SessaoVotacao sessaoVotacao;
    private SessaoDto sessaoDto;

    @BeforeEach
    void setUp() {
        associado = new Associado();
        associado.setNome("Mateus");
        associadoDto = new AssociadoDto();
        associadoDto.setNome("Paloma");

        voto1 = new Voto();
        voto1.setId(1L);
        voto1.setTipoVoto(TipoVoto.NAO);
        voto1.setAssociado(associado);
        voto1.setSessaoVotacao(sessaoVotacao);

        votoDto1 = new VotoDto();
        votoDto1.setId(1L);
        votoDto1.setTipoVoto(TipoVoto.NAO);
        votoDto1.setAssociado(associadoDto);
        votoDto1.setSessaoVotacao(sessaoDto);

        voto2 = new Voto();
        voto2.setId(1L);
        voto2.setTipoVoto(TipoVoto.SIM);
        voto2.setAssociado(associado);
        voto2.setSessaoVotacao(sessaoVotacao);

        votoDto2 = new VotoDto();
        votoDto2.setId(1L);
        votoDto2.setTipoVoto(TipoVoto.SIM);
        votoDto2.setAssociado(associadoDto);
        votoDto2.setSessaoVotacao(sessaoDto);
    }

    @Test
    void criarVoto() {

        when(votoRepository.save(any())).thenReturn(voto2);
        given(modelMapper.map(votoDto2, Voto.class)).willReturn(voto2);
        given(modelMapper.map(voto2, VotoDto.class)).willReturn(votoDto2);

        var votoSalvo = votoService.criarVoto(votoDto2);

        verify(votoRepository, times(1)).save(any());
        assertNotNull(votoSalvo);

        assertEquals(votoSalvo.getTipoVoto(), votoDto2.getTipoVoto());
    }

    @Test
    @DisplayName("Retorna todos os votos cadastrados")
    public void deveListarTodosVotos() {
        List<Voto> votoList = Arrays.asList(voto1,voto2);
        when(votoRepository.findAll()).thenReturn(votoList);

        List<VotoDto> votoDtoList = votoService.listarVotos();

        assertEquals(2,votoList.size());
        assertNotNull(votoDtoList);
    }


}



