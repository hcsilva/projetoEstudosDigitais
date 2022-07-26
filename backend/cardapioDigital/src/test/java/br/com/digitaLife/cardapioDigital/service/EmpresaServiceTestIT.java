package br.com.digitaLife.cardapioDigital.service;

import br.com.digitaLife.cardapioDigital.model.Empresa;
import br.com.digitaLife.cardapioDigital.repository.EmpresaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(value = {"/scripts/insert_table_empresa.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/scripts/clean_table_empresa.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class EmpresaServiceTestIT {

    @Autowired
    private EmpresaService empresaService;

    @MockBean
    private EmpresaRepository empresaRepository;

    @Test
    public void shouldFindOneEmpresa(){
        Optional<Empresa> empresaOptional = empresaRepository.findById(999L);
        when(empresaRepository.findById(999L)).thenReturn(empresaOptional);
    }
}