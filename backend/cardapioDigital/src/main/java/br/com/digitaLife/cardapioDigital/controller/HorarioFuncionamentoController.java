package br.com.digitaLife.cardapioDigital.controller;

import br.com.digitaLife.cardapioDigital.dto.HorarioFuncionamentoDto;
import br.com.digitaLife.cardapioDigital.model.HorarioFuncionamento;
import br.com.digitaLife.cardapioDigital.service.HorarioFuncionamentoService;
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
@RequestMapping("/api/horarioFuncionamento")
public class HorarioFuncionamentoController {
    @Autowired
    private HorarioFuncionamentoService horarioFuncionamentoService;

    @PostMapping
    public ResponseEntity<HorarioFuncionamento> saveHorarioFuncionamento(@RequestBody @Valid HorarioFuncionamentoDto horarioFuncionamentoDto) {
        HorarioFuncionamento horarioFuncionamento = horarioFuncionamentoDto.convertDTOToEntity();
        return ResponseEntity.status(HttpStatus.CREATED).body(horarioFuncionamentoService.save(horarioFuncionamento));
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
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(MessageUtils.getMessage("horarioFuncionamento.deletadoComSucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmpresa(@PathVariable(value = "id") Long id, @RequestBody @Valid HorarioFuncionamentoDto horarioFuncionamentoDto) {
        HorarioFuncionamento horarioFuncionamento = horarioFuncionamentoService.findById(id);
        HorarioFuncionamento horarioFuncionamentoAtualizado = horarioFuncionamentoDto.convertDTOToEntity();
        horarioFuncionamentoAtualizado.setId(horarioFuncionamento.getId());
        return ResponseEntity.status(HttpStatus.OK).body(horarioFuncionamentoService.save(horarioFuncionamentoAtualizado));
    }

}
