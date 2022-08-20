package br.com.digitaLife.cardapioDigital.controller;

import br.com.digitaLife.cardapioDigital.service.EmpresaService;
import br.com.digitaLife.cardapioDigital.util.EmpresaCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
//@ActiveProfiles("teste")
class EmpresaControllerTest {

    @InjectMocks
    private EmpresaController empresaController;

    @Mock
    private EmpresaService empresaService;

    @BeforeEach
    void setUp(){
        BDDMockito.when(empresaService.save(any())).thenReturn(EmpresaCreator.validEmpresa());
    }

    @Test
    @DisplayName("Salva um empresa quando sucesso")
    void shouldSaveCompanyWhenSuccess(){
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


}