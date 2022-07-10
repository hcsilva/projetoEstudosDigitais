package br.com.digitaLife.cardapioDigital.controller;

import br.com.digitaLife.cardapioDigital.dto.EnderecoDto;
import br.com.digitaLife.cardapioDigital.dto.LinksDto;
import br.com.digitaLife.cardapioDigital.model.Endereco;
import br.com.digitaLife.cardapioDigital.model.Links;
import br.com.digitaLife.cardapioDigital.service.LinksService;
import br.com.digitaLife.cardapioDigital.utils.MessageUtils;
import io.swagger.v3.oas.models.links.Link;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping("/api/link")
public class LinksController {

    @Autowired
    private LinksService linksService;

    @PostMapping
    public ResponseEntity<Links> saveLinks(@RequestBody @Valid LinksDto linkDto) {
        var linksModel = new Links();
        BeanUtils.copyProperties(linkDto, linksModel);
        linksModel.setDataCriacaoRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(linksService.save(linksModel));
    }

    @GetMapping
    public ResponseEntity<Page<Links>> findAllLinks(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(linksService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Links links = linksService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(links);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteLinks(@PathVariable(value = "id") Long id) {
        Links links = linksService.findById(id);
        linksService.delete(links);

        return ResponseEntity.status(HttpStatus.OK).body(MessageUtils.getMessage("links.deletadoComSucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLinks(@PathVariable(value = "id") Long id, @RequestBody @Valid LinksDto linksDto) {
        Links links = linksService.findById(id);

        var linksModel = new Links();
        BeanUtils.copyProperties(linksDto, linksModel);
        linksModel.setId(links.getId());
        return ResponseEntity.status(HttpStatus.OK).body(linksService.save(linksModel));
    }
}
