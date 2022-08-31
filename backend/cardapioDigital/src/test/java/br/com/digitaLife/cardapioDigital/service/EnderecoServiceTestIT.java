package br.com.digitaLife.cardapioDigital.service;

import br.com.digitaLife.cardapioDigital.model.Empresa;
import br.com.digitaLife.cardapioDigital.model.Endereco;
import br.com.digitaLife.cardapioDigital.repository.EmpresaRepository;
import br.com.digitaLife.cardapioDigital.repository.EnderecoRepository;
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
@Sql(value = {"/scripts/insert_table_endereco.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/scripts/clean_table_endereco.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class EnderecoServiceTestIT {

    @Autowired
    private EnderecoService enderecoService;

    @MockBean
    private EnderecoRepository enderecoRepository;

    @Test
    public void shouldFindOneEndereco(){
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(999L);
        when(enderecoRepository.findById(999L)).thenReturn(enderecoOptional);
    }
}