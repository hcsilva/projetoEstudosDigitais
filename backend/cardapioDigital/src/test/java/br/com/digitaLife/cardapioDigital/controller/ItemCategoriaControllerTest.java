package br.com.digitaLife.cardapioDigital.controller;

import br.com.digitaLife.cardapioDigital.dto.ItemCategoriaDto;
import br.com.digitaLife.cardapioDigital.model.ItemCategoria;
import br.com.digitaLife.cardapioDigital.service.ItemCategoriaService;
import br.com.digitaLife.cardapioDigital.util.ItemCategoriaCreator;
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
class ItemCategoriaControllerTest {

    @InjectMocks
    private ItemCategoriaController itemCategoriaController;

    @Mock
    private ItemCategoriaService itemCategoriaService;

    @BeforeEach
    void setUp() {
        when(itemCategoriaService.save(any())).thenReturn(ItemCategoriaCreator.itemCategoriaValid());
        when(itemCategoriaService.findById(any())).thenReturn(ItemCategoriaCreator.itemCategoriaValid());
    }

    @Test
    void shouldSaveItemCategoriaWhenSuccess() {
        var responseEntity = itemCategoriaController.saveItemCategoria(ItemCategoriaCreator.createItemCategoriaDtoForSave());
        var itemCategoriaDto = ItemCategoriaCreator.createItemCategoriaDtoForSave();

        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
        Assertions.assertEquals(responseEntity.getBody().getDescricaoDetalhada(), itemCategoriaDto.getDescricaoDetalhada());
        Assertions.assertEquals(responseEntity.getBody().getCategoria().getId(), itemCategoriaDto.getCategoriaId());
        Assertions.assertEquals(responseEntity.getBody().getFoto(), itemCategoriaDto.getFoto());
        Assertions.assertEquals(responseEntity.getBody().getPreco(), itemCategoriaDto.getPreco());
        Assertions.assertEquals(responseEntity.getBody().getDescricaoSimples(), itemCategoriaDto.getDescricaoSimples());
        Assertions.assertEquals(responseEntity.getBody().getPrecoMiniPrato(), itemCategoriaDto.getPrecoMiniPrato());
        Assertions.assertEquals(responseEntity.getBody().getServeQuantidadePessoas(), itemCategoriaDto.getServerQuantidadePessoas());
        Assertions.assertEquals(responseEntity.getBody().isVegetariano(), itemCategoriaDto.isVegetariano());
        Assertions.assertEquals(responseEntity.getBody().isDestaque(), itemCategoriaDto.isDestaque());
        Assertions.assertEquals(responseEntity.getBody().isSemGluten(), itemCategoriaDto.isSemGluten());
        Assertions.assertEquals(responseEntity.getBody().isSemLactose(), itemCategoriaDto.isSemLactose());
        Assertions.assertEquals(responseEntity.getBody().isVegano(), itemCategoriaDto.isVegano());
    }

    @Test
    @SneakyThrows
    void shouldThrowsExceptionWhenSave() {
        itemCategoriaController.saveItemCategoria(new ItemCategoriaDto());
    }

    @Test
    void shouldDeleteItemCategoriaWhenExists() {
        doNothing().when(itemCategoriaService).delete(any());
        var responseEntity = itemCategoriaController.deleteItemCategoria(1L);

        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(ResponseEntity.class, responseEntity.getClass());
        Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(itemCategoriaService, times(1)).delete(any());
    }

    @Test
    @SneakyThrows
    void shouldDThrowsDeleteItemCategoriaWhenNotExists() {
        doNothing().when(itemCategoriaService).delete(any());
        itemCategoriaController.deleteItemCategoria(999L);
    }

    @Test
    void shouldReturnAllItemCategoriasPageableWhenSuccess() {
        var itemCategoriaPage = new PageImpl<>(List.of(ItemCategoriaCreator.itemCategoriaValid()));
        when(itemCategoriaService.findAll(any())).thenReturn(itemCategoriaPage);
        var responseEntity = itemCategoriaController.findAllItemCategoria(any());

        Assertions.assertNotNull(responseEntity);
        Assertions.assertNotNull(responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(ResponseEntity.class, responseEntity.getClass());
        Assertions.assertEquals(PageImpl.class, responseEntity.getBody().getClass());
    }

    @Test
    void shouldUpdateItemCategoriaWhenSuccess() {
        when(itemCategoriaService.save(any())).thenReturn(ItemCategoriaCreator.itemCategoriaUpdateValid());
        var itemCategoriaUpdate = ItemCategoriaCreator.createItemCategoriaToUpdate();
        var responseEntity = itemCategoriaController.updateItemCategoria(1L, itemCategoriaUpdate);

        Assertions.assertNotNull(responseEntity);
        Assertions.assertNotNull(responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(ResponseEntity.class, responseEntity.getClass());
        Assertions.assertEquals(ItemCategoria.class, responseEntity.getBody().getClass());

        Assertions.assertEquals(itemCategoriaUpdate.getDescricaoSimples(), responseEntity.getBody().getDescricaoSimples());
        Assertions.assertEquals(itemCategoriaUpdate.getDescricaoDetalhada(), responseEntity.getBody().getDescricaoDetalhada());
        Assertions.assertEquals(itemCategoriaUpdate.isDestaque(), responseEntity.getBody().isDestaque());
        Assertions.assertEquals(itemCategoriaUpdate.isVegano(), responseEntity.getBody().isVegano());
        Assertions.assertEquals(itemCategoriaUpdate.isVegetariano(), responseEntity.getBody().isVegetariano());
        Assertions.assertEquals(itemCategoriaUpdate.isSemLactose(), responseEntity.getBody().isSemLactose());
        Assertions.assertEquals(itemCategoriaUpdate.getCategoriaId(), responseEntity.getBody().getCategoria().getId());
        Assertions.assertEquals(itemCategoriaUpdate.getFoto(), responseEntity.getBody().getFoto());
        Assertions.assertEquals(itemCategoriaUpdate.getPreco(), responseEntity.getBody().getPreco());
        Assertions.assertEquals(itemCategoriaUpdate.getPrecoMiniPrato(), responseEntity.getBody().getPrecoMiniPrato());
    }
}