package com.mateus.desafiosicredi.services;

import com.mateus.desafiosicredi.dto.AssociadoDto;
import com.mateus.desafiosicredi.models.Associado;
import com.mateus.desafiosicredi.models.Voto;
import com.mateus.desafiosicredi.repositories.AssociadoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AssociadoServiceTest {

    @Mock
    private AssociadoRepository associadoRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private AssociadoService associadoService;

    private Associado associado1;
    private AssociadoDto associadoDto1;
    private Associado associado2;

    private AssociadoDto associadoDto2;
    private final List<Voto> votos = new ArrayList<>();

    @BeforeEach
    void setUp() {
        associado1 = new Associado();
        associado1.setId(1L);
        associado1.setNome("Mateus");
        associado1.setVotos(votos);

        associadoDto1 = new AssociadoDto();
        associadoDto1.setNome("Mateus");
        associadoDto1.setId(1L);
        associadoDto1.setVotos(votos);

        associado2 = new Associado();
        associado2.setId(2L);
        associado2.setNome("Paloma");
        associado2.setVotos(votos);

        associadoDto2 = new AssociadoDto();
        associadoDto2.setNome("Paloma");
        associadoDto2.setId(2L);
        associadoDto2.setVotos(votos);

    }

    @Test
    void criarAssociado() {

        when(associadoRepository.save(any())).thenReturn(associado1);
        given(modelMapper.map(associadoDto1, Associado.class)).willReturn(associado1);
        given(modelMapper.map(associado1, AssociadoDto.class)).willReturn(associadoDto1);

        var associadoSalvo = associadoService.criarAssociado(associadoDto1);

        verify(associadoRepository,times(1)).save(associado1);
        assertNotNull(associadoSalvo);
    }

    @Test
    @DisplayName("Retorna todos os associados cadastrados")
    public void deveListarTodosAssociados() {
        List<Associado> associadoList = Arrays.asList(associado1,associado2);
        when(associadoRepository.findAll()).thenReturn(associadoList);

        List<AssociadoDto> associadoDtos = associadoService.listarAssociados();

        assertEquals(2,associadoList.size());
        assertNotNull(associadoDtos);
    }
}