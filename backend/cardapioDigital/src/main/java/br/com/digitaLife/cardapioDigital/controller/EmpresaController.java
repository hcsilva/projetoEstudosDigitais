package br.com.digitaLife.cardapioDigital.controller;

import br.com.digitaLife.cardapioDigital.dto.EmpresaDto;
import br.com.digitaLife.cardapioDigital.model.Empresa;
import br.com.digitaLife.cardapioDigital.service.EmpresaService;
import br.com.digitaLife.cardapioDigital.utils.MessageUtils;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("api/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> saveEmpresa(@RequestBody @Valid EmpresaDto empresaDto) {
        var empresaModel = new Empresa();
        BeanUtils.copyProperties(empresaDto, empresaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(empresaModel));
    }

    @GetMapping
    public ResponseEntity<Page<Empresa>> findAllEmpresas(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Empresa empresa = empresaService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(empresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmpresa(@PathVariable(value = "id") Long id) {
        Empresa empresa = empresaService.findById(id);
        empresaService.delete(empresa);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(MessageUtils.getMessage("empresa.deletadaComSucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmpresa(@PathVariable(value = "id") Long id, @RequestBody @Valid EmpresaDto empresaDto) {
        Empresa empresa = empresaService.findById(id);

        var empresaModel = new Empresa();
        BeanUtils.copyProperties(empresaDto, empresaModel);
        empresaModel.setId(empresa.getId());

        return ResponseEntity.status(HttpStatus.OK).body(empresaService.save(empresaModel));
    }

}
