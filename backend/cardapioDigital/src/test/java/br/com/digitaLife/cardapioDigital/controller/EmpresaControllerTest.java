package br.com.digitaLife.cardapioDigital.controller;

import br.com.digitaLife.cardapioDigital.dto.EmpresaDto;
import br.com.digitaLife.cardapioDigital.model.Empresa;
import br.com.digitaLife.cardapioDigital.service.EmpresaService;
import br.com.digitaLife.cardapioDigital.util.EmpresaCreator;
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
class EmpresaControllerTest {

    @InjectMocks
    private EmpresaController empresaController;

    @Mock
    private EmpresaService empresaService;

    @BeforeEach
    void setUp() {
        when(empresaService.findById(any())).thenReturn(EmpresaCreator.validEmpresa());
    }

    @Test
    @DisplayName("Salva uma empresa quando sucesso")
    void shouldSaveCompanyWhenSuccess() {
        when(empresaService.save(any())).thenReturn(EmpresaCreator.validEmpresa());
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
    void shouldDeleteEmpresaWhenExists() {
        doNothing().when(empresaService).delete(any());
        ResponseEntity<Object> responseEntity = empresaController.deleteEmpresa(1L);

        assertNotNull(responseEntity);
        assertEquals(ResponseEntity.class, responseEntity.getClass());
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(empresaService, times(1)).delete(any());
    }

    @Test
    void shouldReturnAllEmpresasPageableWhenSuccess() {
        PageImpl<Empresa> empresaPage = new PageImpl<>(List.of(EmpresaCreator.validEmpresa()));

        when(empresaService.findAll(any())).thenReturn(empresaPage);
        ResponseEntity<Page<Empresa>> empresasResponse = empresaController.findAllEmpresas(null);

        assertNotNull(empresasResponse);
        assertNotNull(empresasResponse.getBody());
        assertEquals(HttpStatus.OK, empresasResponse.getStatusCode());
        assertEquals(ResponseEntity.class, empresasResponse.getClass());
        assertEquals(PageImpl.class, empresasResponse.getBody().getClass());
    }

    @Test
    void shouldUpdateEmpresaWhenSuccess() {
        when(empresaService.save(any())).thenReturn(EmpresaCreator.empresaUpdateValid());
        EmpresaDto empresaUpdate = EmpresaCreator.createEmpresaDtoToUpdate();

        ResponseEntity<Empresa> response = empresaController.updateEmpresa(1L, empresaUpdate);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(Empresa.class, response.getBody().getClass());

        assertEquals(empresaUpdate.getRazaoSocial(), response.getBody().getRazaoSocial());
        assertEquals(empresaUpdate.getDescricao(), response.getBody().getDescricao());
        assertEquals(empresaUpdate.getEmail(), response.getBody().getEmail());
        assertEquals(empresaUpdate.getFacebook(), response.getBody().getFacebook());
        assertEquals(empresaUpdate.getInstagram(), response.getBody().getInstagram());
        assertEquals(empresaUpdate.getSite(), response.getBody().getSite());
        assertEquals(empresaUpdate.getTelefoneContato(), response.getBody().getTelefoneContato());
        assertEquals(empresaUpdate.getWhatsapp(), response.getBody().getWhatsapp());
    }
}