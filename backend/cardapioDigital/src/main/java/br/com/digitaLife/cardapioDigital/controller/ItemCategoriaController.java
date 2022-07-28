package br.com.digitaLife.cardapioDigital.controller;

import br.com.digitaLife.cardapioDigital.dto.CategoriaDto;
import br.com.digitaLife.cardapioDigital.dto.ItemCategoriaDto;
import br.com.digitaLife.cardapioDigital.model.Categoria;
import br.com.digitaLife.cardapioDigital.model.ItemCategoria;
import br.com.digitaLife.cardapioDigital.service.CategoriaService;
import br.com.digitaLife.cardapioDigital.service.ItemCategoriaService;
import br.com.digitaLife.cardapioDigital.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/itemCategoria")
public class ItemCategoriaController {
    @Autowired
    private ItemCategoriaService itemCategoriaService;

    @PostMapping
    public ResponseEntity<ItemCategoria> saveItemCategoria(@RequestBody @Valid ItemCategoriaDto itemCategoriaDto) {
        ItemCategoria itemCategoria = itemCategoriaDto.convertDTOToEntity();
        return ResponseEntity.status(HttpStatus.CREATED).body(itemCategoriaService.save(itemCategoria));
    }

    @GetMapping
    public ResponseEntity<Page<ItemCategoria>> findAllItemCategoria(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(itemCategoriaService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        ItemCategoria itemCategoria = itemCategoriaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(itemCategoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteItemCategoria(@PathVariable(value = "id") Long id) {
        ItemCategoria itemCategoria = itemCategoriaService.findById(id);
        itemCategoriaService.delete(itemCategoria);
        return ResponseEntity.status(HttpStatus.OK).body(MessageUtils.getMessage("itemCategoria.deletadoComSucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateItemCategoria(@PathVariable(value = "id") Long id, @RequestBody @Valid ItemCategoriaDto itemCategoriaDto) {
        ItemCategoria itemCategoria = itemCategoriaService.findById(id);
        ItemCategoria itemCategoriaAtualizado = itemCategoriaDto.convertDTOToEntity();
        itemCategoriaAtualizado.setId(itemCategoria.getId());
        return ResponseEntity.status(HttpStatus.OK).body(itemCategoriaService.save(itemCategoriaAtualizado));
    }

}
