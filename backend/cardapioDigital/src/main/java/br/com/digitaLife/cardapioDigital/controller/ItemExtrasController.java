package br.com.digitaLife.cardapioDigital.controller;

import br.com.digitaLife.cardapioDigital.dto.ItemCategoriaDto;
import br.com.digitaLife.cardapioDigital.dto.ItemExtrasDto;
import br.com.digitaLife.cardapioDigital.model.ItemCategoria;
import br.com.digitaLife.cardapioDigital.model.ItemExtras;
import br.com.digitaLife.cardapioDigital.service.ItemCategoriaService;
import br.com.digitaLife.cardapioDigital.service.ItemExtrasService;
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
@RequestMapping("/api/itemExtras")
public class ItemExtrasController {
    @Autowired
    private ItemExtrasService itemExtrasService;

    @PostMapping
    public ResponseEntity<ItemExtras> saveItemExtras(@RequestBody @Valid ItemExtrasDto itemExtrasDto) {
        ItemExtras itemExtras = itemExtrasDto.convertDTOToEntity();
        return ResponseEntity.status(HttpStatus.CREATED).body(itemExtrasService.save(itemExtras));
    }

    @GetMapping
    public ResponseEntity<Page<ItemExtras>> findAllItemExtras(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(itemExtrasService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        ItemExtras itemExtras = itemExtrasService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(itemExtras);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteItemExtras(@PathVariable(value = "id") Long id) {
        ItemExtras itemExtras = itemExtrasService.findById(id);
        itemExtrasService.delete(itemExtras);
        return ResponseEntity.status(HttpStatus.OK).body(MessageUtils.getMessage("itemExtras.deletadoComSucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateItemExtras(@PathVariable(value = "id") Long id, @RequestBody @Valid ItemExtrasDto itemExtrasDto) {
        ItemExtras itemExtras = itemExtrasService.findById(id);
        ItemExtras itemExtrasAtualizado = itemExtrasDto.convertDTOToEntity();
        itemExtrasAtualizado.setId(itemExtras.getId());
        return ResponseEntity.status(HttpStatus.OK).body(itemExtrasService.save(itemExtrasAtualizado));
    }

}
