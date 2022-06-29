package br.com.digitaLife.cardapioDigital;


import br.com.digitaLife.cardapioDigital.controller.EmpresaController;
import br.com.digitaLife.cardapioDigital.dto.EmpresaDto;
import br.com.digitaLife.cardapioDigital.model.Empresa;
import br.com.digitaLife.cardapioDigital.service.EmpresaService;
import br.com.digitaLife.cardapioDigital.util.EmpresaCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

@ExtendWith(SpringExtension.class)
public class EmpresaServiceTest {

    @InjectMocks
    private EmpresaController empresaController;

    @Mock
    private EmpresaService empresaService;

    @Test
    @DisplayName("Salva um empresa quando sucesso")
    void salve_retorna_pessoa_quando_sucesso() throws IOException {
        EmpresaDto empresaDto = EmpresaCreator.createEmpresaForSave();
        ResponseEntity<Object> responseEntity = empresaController.saveEmpresa(empresaDto);
        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
    }

}
