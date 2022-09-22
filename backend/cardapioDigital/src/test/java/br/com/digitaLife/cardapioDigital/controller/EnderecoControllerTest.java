package br.com.digitaLife.cardapioDigital.controller;

import br.com.digitaLife.cardapioDigital.dto.EnderecoDto;
import br.com.digitaLife.cardapioDigital.model.Endereco;
import br.com.digitaLife.cardapioDigital.service.EnderecoService;
import br.com.digitaLife.cardapioDigital.util.EnderecoCreator;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
//@ActiveProfiles("teste")
class EnderecoControllerTest {

    @InjectMocks
    private EnderecoController enderecoController;

    @Mock
    private EnderecoService enderecoService;

    @BeforeEach
    void setUp() {
        when(enderecoService.save(any())).thenReturn(EnderecoCreator.validEndereco());
        when(enderecoService.findById(any())).thenReturn(EnderecoCreator.validEndereco());
    }

    @Test
    @DisplayName("Salva um endereco quando sucesso")
    void shouldSaveAddressWhenSuccess() {
        var enderecoDto = EnderecoCreator.createEnderecoDtoForSave();
        var responseEntity = enderecoController.saveEndereco(enderecoDto);

        Assertions.assertNotNull(responseEntity.getBody());

        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
        Assertions.assertEquals(responseEntity.getBody().getBairro(), enderecoDto.getBairro());
        Assertions.assertEquals(responseEntity.getBody().getCidade(), enderecoDto.getCidade());
        Assertions.assertEquals(responseEntity.getBody().getComplemento(), enderecoDto.getComplemento());
        Assertions.assertEquals(responseEntity.getBody().getEstado(), enderecoDto.getEstado());
        Assertions.assertEquals(responseEntity.getBody().getCep(), enderecoDto.getCep());
        Assertions.assertEquals(responseEntity.getBody().getNumero(), enderecoDto.getNumero());
        Assertions.assertEquals(responseEntity.getBody().getLogradouro(), enderecoDto.getLogradouro());
        Assertions.assertEquals(responseEntity.getBody().getPais(), enderecoDto.getPais());
    }

    @Test
    void shouldThrowsExceptionWhenSave() {
        try {
            var enderecoDto = new EnderecoDto();
            enderecoController.saveEndereco(enderecoDto);
        } catch (Exception e) {
            assertEquals(ResponseStatusException.class, e.getClass());
        }
    }

    @Test
    void shouldDeleteEnderecoWhenExists(){
        doNothing().when(enderecoService).delete(any());
        ResponseEntity<Object> responseEntity = enderecoController.deleteEndereco(1L);

        assertNotNull(responseEntity);
        assertEquals(ResponseEntity.class, responseEntity.getClass());
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(enderecoService, times(1)).delete(any());
    }

    @Test
    void shouldReturnAllEnderecoPageableWhenSuccess() {
        PageImpl<Endereco> enderecoPage = new PageImpl<>(List.of(EnderecoCreator.validEndereco()));

        when(enderecoService.findAll(any())).thenReturn(enderecoPage);
        ResponseEntity<Page<Endereco>> enderecoResponse = enderecoController.findAllEmpresas(null);

        assertNotNull(enderecoResponse);
        assertNotNull(enderecoResponse.getBody());
        assertEquals(HttpStatus.OK, enderecoResponse.getStatusCode());
        assertEquals(ResponseEntity.class, enderecoResponse.getClass());
        assertEquals(PageImpl.class, enderecoResponse.getBody().getClass());
    }

    @Test
    void shouldUpdateEnderecoWhenSuccess() {
        when(enderecoService.save(any())).thenReturn(EnderecoCreator.enderecoUpdateValid());
        EnderecoDto enderecoUpdate = EnderecoCreator.createEnderecoDtoToUpdate();

        ResponseEntity<Endereco> response = enderecoController.updateEndereco(1L, enderecoUpdate);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(Endereco.class, response.getBody().getClass());

        assertEquals(enderecoUpdate.getLogradouro(), response.getBody().getLogradouro());
        assertEquals(enderecoUpdate.getBairro(), response.getBody().getBairro());
        assertEquals(enderecoUpdate.getCep(), response.getBody().getCep());
        assertEquals(enderecoUpdate.getCidade(), response.getBody().getCidade());
        assertEquals(enderecoUpdate.getComplemento(), response.getBody().getComplemento());
        assertEquals(enderecoUpdate.getEstado(), response.getBody().getEstado());
        assertEquals(enderecoUpdate.getNumero(), response.getBody().getNumero());
        assertEquals(enderecoUpdate.getPais(), response.getBody().getPais());
    }

}