package br.com.digitaLife.cardapioDigital.controller;

import br.com.digitaLife.cardapioDigital.dto.FormaPagamentoDto;
import br.com.digitaLife.cardapioDigital.model.FormaPagamento;
import br.com.digitaLife.cardapioDigital.service.FormaPagamentoService;
import br.com.digitaLife.cardapioDigital.util.FormaPagamentoCreator;
import java.util.List;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class FormaPagamentoControllerTest {

    @InjectMocks
    private FormaPagamentoController formaPagamentoController;

    @Mock
    private FormaPagamentoService formaPagamentoService;

    @BeforeEach
    void setUp() {
        when(formaPagamentoService.save(any())).thenReturn(FormaPagamentoCreator.formaPagamentoValid());
        when(formaPagamentoService.findById(any())).thenReturn(FormaPagamentoCreator.formaPagamentoValid());
    }

    @Test
    void shouldSaveFormaPagamentoWhenSuccess() {
        var responseEntity = formaPagamentoController.saveFormaPagamento(FormaPagamentoCreator.createFormaPagamentoDtoForSave());
        var formaPagamentoDto = FormaPagamentoCreator.createFormaPagamentoDtoForSave();

        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
        Assertions.assertEquals(responseEntity.getBody().isCartaoCredito(), formaPagamentoDto.isCartaoCredito());
        Assertions.assertEquals(responseEntity.getBody().isDinheiro(), formaPagamentoDto.isDinheiro());
        Assertions.assertEquals(responseEntity.getBody().isVisivel(), formaPagamentoDto.isVisivel());
        Assertions.assertEquals(responseEntity.getBody().isCartaoDebito(), formaPagamentoDto.isCartaoDebito());
        Assertions.assertEquals(responseEntity.getBody().isValeRefeicao(), formaPagamentoDto.isValeRefeicao());
    }

    @Test
    @SneakyThrows
    void shouldThrowsExceptionWhenSave() {
        formaPagamentoController.saveFormaPagamento(new FormaPagamentoDto());
    }

    @Test
    void shouldDeleteFormaPagamentoWhenExists() {
        doNothing().when(formaPagamentoService).delete(any());
        var responseEntity = formaPagamentoController.deleteFormaPagamento(1L);

        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(ResponseEntity.class, responseEntity.getClass());
        Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(formaPagamentoService, times(1)).delete(any());
    }

    @Test
    @SneakyThrows
    void shouldDThrowsDeleteFormaPagamentoWhenNotExists() {
        doNothing().when(formaPagamentoService).delete(any());
        formaPagamentoController.deleteFormaPagamento(999L);
    }

    @Test
    void shouldReturnAllFormaPagamentoPageableWhenSuccess() {
        var formaPagamentoPage = new PageImpl<>(List.of(FormaPagamentoCreator.formaPagamentoValid()));
        when(formaPagamentoService.findAll(any())).thenReturn(formaPagamentoPage);
        var responseEntity = formaPagamentoController.findAllFormaPagamento(any());

        Assertions.assertNotNull(responseEntity);
        Assertions.assertNotNull(responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(ResponseEntity.class, responseEntity.getClass());
        Assertions.assertEquals(PageImpl.class, responseEntity.getBody().getClass());
    }

    @Test
    void shouldUpdateFormaPagamentoWhenSuccess() {
        when(formaPagamentoService.save(any())).thenReturn(FormaPagamentoCreator.formaPagamentoUpdateValid());
        var formaPagamentoUpdate = FormaPagamentoCreator.createFormaPagamentoToUpdate();
        var responseEntity = formaPagamentoController.updateFormaPagamento(1L, formaPagamentoUpdate);

        Assertions.assertNotNull(responseEntity);
        Assertions.assertNotNull(responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(ResponseEntity.class, responseEntity.getClass());
        Assertions.assertEquals(FormaPagamento.class, responseEntity.getBody().getClass());

        Assertions.assertEquals(formaPagamentoUpdate.isVisivel(), responseEntity.getBody().isVisivel());
        Assertions.assertEquals(formaPagamentoUpdate.isDinheiro(), responseEntity.getBody().isDinheiro());
        Assertions.assertEquals(formaPagamentoUpdate.isCartaoDebito(), responseEntity.getBody().isCartaoDebito());
        Assertions.assertEquals(formaPagamentoUpdate.isCartaoCredito(), responseEntity.getBody().isCartaoCredito());
        Assertions.assertEquals(formaPagamentoUpdate.isValeRefeicao(), responseEntity.getBody().isValeRefeicao());
    }
}