package br.com.digitaLife.cardapioDigital.controller;

import br.com.digitaLife.cardapioDigital.dto.HorarioFuncionamentoDto;
import br.com.digitaLife.cardapioDigital.model.HorarioFuncionamento;
import br.com.digitaLife.cardapioDigital.service.EmpresaService;
import br.com.digitaLife.cardapioDigital.service.HorarioFuncionamentoService;
import br.com.digitaLife.cardapioDigital.utils.MessageUtils;
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
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping("/api/horarioFuncionamento")
public class HorarioFuncionamentoController {

    @Autowired
    private HorarioFuncionamentoService horarioFuncionamentoService;

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<HorarioFuncionamento> saveHorarioFuncionamento(@RequestBody @Valid HorarioFuncionamentoDto horarioFuncionamentoDto) {
        var empresa = empresaService.findById(horarioFuncionamentoDto.getEmpresa());

        var horarioFuncionamentoModel = new HorarioFuncionamento();
        BeanUtils.copyProperties(horarioFuncionamentoDto, horarioFuncionamentoModel);
        horarioFuncionamentoModel.setDataCriacaoRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        horarioFuncionamentoModel.setEmpresa(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(horarioFuncionamentoService.save(horarioFuncionamentoModel));
    }

    @GetMapping
    public ResponseEntity<Page<HorarioFuncionamento>> findAllHorariosFuncionamento(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(horarioFuncionamentoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        HorarioFuncionamento horarioFuncionamento = horarioFuncionamentoService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(horarioFuncionamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmpresa(@PathVariable(value = "id") Long id) {
        HorarioFuncionamento horarioFuncionamento = horarioFuncionamentoService.findById(id);
        horarioFuncionamentoService.delete(horarioFuncionamento);
        return ResponseEntity.status(HttpStatus.OK).body(MessageUtils.getMessage("horarioFuncionamento.deletadoComSucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmpresa(@PathVariable(value = "id") Long id, @RequestBody @Valid HorarioFuncionamentoDto horarioFuncionamentoDto) {
        HorarioFuncionamento horarioFuncionamento = horarioFuncionamentoService.findById(id);

        var horarioFuncionamentoModel = new HorarioFuncionamento();
        BeanUtils.copyProperties(horarioFuncionamentoDto, horarioFuncionamentoModel);
        horarioFuncionamentoModel.setId(horarioFuncionamento.getId());

        return ResponseEntity.status(HttpStatus.OK).body(horarioFuncionamentoService.save(horarioFuncionamentoModel));
    }

}
