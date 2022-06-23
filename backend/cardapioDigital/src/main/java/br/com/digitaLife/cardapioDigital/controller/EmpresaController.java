package br.com.digitaLife.cardapioDigital.controller;

import br.com.digitaLife.cardapioDigital.dto.EmpresaDto;
import br.com.digitaLife.cardapioDigital.model.Empresa;
import br.com.digitaLife.cardapioDigital.service.EmpresaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.ResourceBundle;

@RestController
@RequestMapping("api/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Object> saveEmpresa(@RequestBody @Valid EmpresaDto empresaDto) {
        var empresaModel = new Empresa();
        BeanUtils.copyProperties(empresaDto, empresaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(empresaModel));
    }

    @GetMapping
    public ResponseEntity<Page<Empresa>> getAllEmpresas(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages");
        Optional<Empresa> empresaOptional = empresaService.findById(id);
        if (!empresaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bundle.getString("empresa.naoEncontrada"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(empresaOptional.get());
    }


}
