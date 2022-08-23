package br.com.digitaLife.cardapioDigital.controller;

import br.com.digitaLife.cardapioDigital.dto.EmpresaDto;
import br.com.digitaLife.cardapioDigital.service.EmpresaService;
import br.com.digitaLife.cardapioDigital.util.EmpresaCreator;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
//@ActiveProfiles("teste")
class EmpresaControllerTest {

    @InjectMocks
    private EmpresaController empresaController;

    @Mock
    private EmpresaService empresaService;

    @BeforeEach
    void setUp() {
        when(empresaService.save(any())).thenReturn(EmpresaCreator.validEmpresa());
    }

    @Test
    @DisplayName("Salva uma empresa quando sucesso")
    void shouldSaveCompanyWhenSuccess() {
        var empresaDto = EmpresaCreator.createEmpresaDtoForSave();
        var responseEntity = empresaController.saveEmpresa(empresaDto);

        Assertions.assertNotNull(responseEntity.getBody());

        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
        Assertions.assertEquals(responseEntity.getBody().getCnpj(), empresaDto.getCnpj());
        Assertions.assertEquals(responseEntity.getBody().getDescricao(), empresaDto.getDescricao());
        Assertions.assertEquals(responseEntity.getBody().getEmail(), empresaDto.getEmail());
        Assertions.assertEquals(responseEntity.getBody().getLogo(), empresaDto.getLogo());
        Assertions.assertEquals(responseEntity.getBody().getImagemCapa(), empresaDto.getImagemCapa());
        Assertions.assertEquals(responseEntity.getBody().getFacebook(), empresaDto.getFacebook());
        Assertions.assertEquals(responseEntity.getBody().getInstagram(), empresaDto.getInstagram());
        Assertions.assertEquals(responseEntity.getBody().getRazaoSocial(), empresaDto.getRazaoSocial());
        Assertions.assertEquals(responseEntity.getBody().getSite(), empresaDto.getSite());
        Assertions.assertEquals(responseEntity.getBody().getTelefoneContato(), empresaDto.getTelefoneContato());
        Assertions.assertEquals(responseEntity.getBody().getWhatsapp(), empresaDto.getWhatsapp());
    }

    @Test
    void shouldThrowsExceptionWhenSave() {
        try {
            var empresaDto = new EmpresaDto();
            empresaController.saveEmpresa(empresaDto);
        } catch (Exception e) {
            assertEquals(ResponseStatusException.class, e.getClass());
        }
    }

    @Test
    void shouldDeleteEmpresaWhenExists(){
        when(empresaService.findById(any())).thenReturn(EmpresaCreator.validEmpresa());
        doNothing().when(empresaService).delete(any());
        ResponseEntity<Object> responseEntity = empresaController.deleteEmpresa(1L);

        assertNotNull(responseEntity);
        assertEquals(ResponseEntity.class, responseEntity.getClass());
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(empresaService, times(1)).delete(any());
    }


}