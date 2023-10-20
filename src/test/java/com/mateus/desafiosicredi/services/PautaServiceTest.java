package com.mateus.desafiosicredi.services;

import com.mateus.desafiosicredi.dto.PautaDto;
import com.mateus.desafiosicredi.models.Pauta;
import com.mateus.desafiosicredi.repositories.PautaRepository;
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
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class PautaServiceTest {

    @Mock
    private PautaRepository pautaRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private PautaService pautaService;

    private Pauta pauta;
    private Pauta pauta2;

    private PautaDto pautaDto;

    private PautaDto pautaDto2;

    @BeforeEach
    void setUp() {
        pauta = new Pauta();
        pauta.setId(1L);
        pauta.setTitulo("Tentando criar o teste");
        pauta.setDescricao("Tenho que conseguir criar esses testes");

        pautaDto = new PautaDto();
        pautaDto.setId(1L);
        pautaDto.setTitulo("Pauta foi salva");
        pautaDto.setDescricao("Estamos tentando o teste");

        pauta2 = new Pauta();
        pauta2.setId(2L);
        pauta2.setTitulo("Tentando criar o teste");
        pauta2.setDescricao("Tenho que conseguir criar esses testes");

        pautaDto2 = new PautaDto();
        pautaDto2.setId(2L);
        pautaDto2.setTitulo("Pauta foi salva");
        pautaDto2.setDescricao("Estamos tentando o teste");
    }

    @Test
    @DisplayName("Salva uma pauta e verifica se não esta nulo")
    void deveSalvarPauta(){
        //Arrange
        when(pautaRepository.save(any())).thenReturn(pauta);
        given(modelMapper.map(pautaDto, Pauta.class)).willReturn(pauta);
        given(modelMapper.map(pauta, PautaDto.class)).willReturn(pautaDto);
        //ACT
        var pautaSalva = pautaService.criarPauta(pautaDto);

        //ASSERT
        verify(pautaRepository, times(1)).save(any());
        assertNotNull(pautaSalva);
    }

    @Test
    @DisplayName("Retorna todas as Pautas cadastradas")
    public void testListarTodasAsPautas() {
        List<Pauta> pautaList = Arrays.asList(pauta,pauta2);
        when(pautaRepository.findAll()).thenReturn(pautaList);

        List<PautaDto> pautaDtos = pautaService.listarPautas();

        assertEquals(2,pautaList.size());
        assertNotNull(pautaDtos);
    }




}