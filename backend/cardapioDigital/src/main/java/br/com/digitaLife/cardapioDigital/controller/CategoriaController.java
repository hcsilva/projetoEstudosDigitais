package br.com.digitaLife.cardapioDigital.controller;

import br.com.digitaLife.cardapioDigital.dto.CategoriaDto;
import br.com.digitaLife.cardapioDigital.model.Categoria;
import br.com.digitaLife.cardapioDigital.service.CategoriaService;
import br.com.digitaLife.cardapioDigital.utils.MessageUtils;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> saveCategoria(@RequestBody @Valid CategoriaDto categoriaDto) {
        Categoria categoria = categoriaDto.convertDTOToEntity();
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }

    @GetMapping
    public ResponseEntity<Page<Categoria>> findAllCategoria(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Categoria categoria = categoriaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategoria(@PathVariable(value = "id") Long id) {
        Categoria categoria = categoriaService.findById(id);
        categoriaService.delete(categoria);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(MessageUtils.getMessage("categoria.deletadoComSucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable(value = "id") Long id, @RequestBody @Valid CategoriaDto categoriaDto) {
        Categoria categoria = categoriaService.findById(id);
        Categoria categoriaAtualizado = categoriaDto.convertDTOToEntity();
        categoriaAtualizado.setId(categoria.getId());
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.save(categoriaAtualizado));
    }

}
