package br.com.digitaLife.cardapioDigital.controller;

import br.com.digitaLife.cardapioDigital.dto.FormaPagamentoDto;
import br.com.digitaLife.cardapioDigital.model.FormaPagamento;
import br.com.digitaLife.cardapioDigital.service.FormaPagamentoService;
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
@RequestMapping("/api/formaPagamento")
public class FormaPagamentoController {
    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @PostMapping
    public ResponseEntity<FormaPagamento> saveFormaPagamento(@RequestBody @Valid FormaPagamentoDto formaPagamentoDto) {
        FormaPagamento formaPagamento = formaPagamentoDto.convertDTOToEntity();
        return ResponseEntity.status(HttpStatus.CREATED).body(formaPagamentoService.save(formaPagamento));
    }

    @GetMapping
    public ResponseEntity<Page<FormaPagamento>> findAllFormaPagamento(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(formaPagamentoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        FormaPagamento formaPagamento = formaPagamentoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(formaPagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFormaPagamento(@PathVariable(value = "id") Long id) {
        FormaPagamento formaPagamento = formaPagamentoService.findById(id);
        formaPagamentoService.delete(formaPagamento);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(MessageUtils.getMessage("formaPagamento.deletadoComSucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormaPagamento> updateFormaPagamento(@PathVariable(value = "id") Long id, @RequestBody @Valid FormaPagamentoDto formaPagamentoDto) {
        FormaPagamento formaPagamento = formaPagamentoService.findById(id);
        FormaPagamento formaPagamentoAtualizado = formaPagamentoDto.convertDTOToEntity();
        formaPagamentoAtualizado.setId(formaPagamento.getId());
        return ResponseEntity.status(HttpStatus.OK).body(formaPagamentoService .save(formaPagamentoAtualizado));
    }

}
