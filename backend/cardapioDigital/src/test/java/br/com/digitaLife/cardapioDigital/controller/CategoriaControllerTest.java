package br.com.digitaLife.cardapioDigital.controller;

import br.com.digitaLife.cardapioDigital.dto.CategoriaDto;
import br.com.digitaLife.cardapioDigital.model.Categoria;
import br.com.digitaLife.cardapioDigital.service.CategoriaService;
import br.com.digitaLife.cardapioDigital.util.CategoriaCreator;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class CategoriaControllerTest {

    @InjectMocks
    private CategoriaController categoriaController;

    @Mock
    private CategoriaService categoriaService;

    @BeforeEach
    void setUp(){
        when(categoriaService.save(any())).thenReturn(CategoriaCreator.categoriaValid());
        when(categoriaService.findById(any())).thenReturn(CategoriaCreator.categoriaValid());
    }

    @Test
    void shouldSaveCategoriaWhenSuccess(){
        var responseEntity =  categoriaController.saveCategoria(CategoriaCreator.createCategoriaDtoForSave());
        var categoriaDto = CategoriaCreator.createCategoriaDtoForSave();

        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
        Assertions.assertEquals(responseEntity.getBody().getDescricaoDetalhada(), categoriaDto.getDescricaoDetalhada());
        Assertions.assertEquals(responseEntity.getBody().getDescricaoSimples(), categoriaDto.getDescricaoSimples());
        Assertions.assertEquals(responseEntity.getBody().getLabelMiniPrato(), categoriaDto.getLabelMiniPrato());
    }

    @Test
    @SneakyThrows
    void shouldThrowsExceptionWhenSave(){
        categoriaController.saveCategoria(new CategoriaDto());
    }

    @Test
    void shouldDeleteCategoriaWhenExists(){
        doNothing().when(categoriaService).delete(any());
        var responseEntity = categoriaController.deleteCategoria(1L);

        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(ResponseEntity.class, responseEntity.getClass());
        Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(categoriaService, times(1)).delete(any());
    }

    @Test
    @SneakyThrows
    void shouldDThrowsDeleteCategoriaWhenNotExists(){
        doNothing().when(categoriaService).delete(any());
        var responseEntity = categoriaController.deleteCategoria(999L);
    }

    @Test
    void shouldReturnAllCategoriasPageableWhenSuccess(){
        var categoriaPage = new PageImpl<>(List.of(CategoriaCreator.categoriaValid()));
        when(categoriaService.findAll(any())).thenReturn(categoriaPage);
        var responseEntity = categoriaController.findAllCategoria(any());

        Assertions.assertNotNull(responseEntity);
        Assertions.assertNotNull(responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(ResponseEntity.class, responseEntity.getClass());
        Assertions.assertEquals(PageImpl.class, responseEntity.getBody().getClass());
    }

    @Test
    void shouldUpdateCategoriaWhenSuccess(){
        when(categoriaService.save(any())).thenReturn(CategoriaCreator.categoriaUpdateValid());
        var categoriaUpdate = CategoriaCreator.createCategoriaToUpdate();
        var responseEntity = categoriaController.updateCategoria(1L, categoriaUpdate);

        Assertions.assertNotNull(responseEntity);
        Assertions.assertNotNull(responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(ResponseEntity.class, responseEntity.getClass());
        Assertions.assertEquals(Categoria.class, responseEntity.getBody().getClass());

        Assertions.assertEquals(categoriaUpdate.getDescricaoSimples(), responseEntity.getBody().getDescricaoSimples());
        Assertions.assertEquals(categoriaUpdate.getDescricaoDetalhada(), responseEntity.getBody().getDescricaoDetalhada());
        Assertions.assertEquals(categoriaUpdate.getLabelMiniPrato(), responseEntity.getBody().getLabelMiniPrato());
    }
}