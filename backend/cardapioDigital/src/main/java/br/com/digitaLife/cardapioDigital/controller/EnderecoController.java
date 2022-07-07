package br.com.digitaLife.cardapioDigital.controller;

import br.com.digitaLife.cardapioDigital.dto.EmpresaDto;
import br.com.digitaLife.cardapioDigital.dto.EnderecoDto;
import br.com.digitaLife.cardapioDigital.model.Empresa;
import br.com.digitaLife.cardapioDigital.model.Endereco;
import br.com.digitaLife.cardapioDigital.service.EnderecoService;
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
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> saveEndereco(@RequestBody @Valid EnderecoDto enderecoDto) {
        var enderecoModel = new Endereco();
        BeanUtils.copyProperties(enderecoDto, enderecoModel);
        enderecoModel.setDataCriacaoRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(enderecoModel));
    }

    @GetMapping
    public ResponseEntity<Page<Endereco>> findAllEmpresas(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findAll(pageable));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Endereco> enderecoOptional = enderecoService.findById(id);
        if (!enderecoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MessageUtils.getMessage("endereco.naoEncontrado"));
        }

        return ResponseEntity.status(HttpStatus.OK).body(enderecoOptional.get());
    }


    @GetMapping("/{cep}")
    @ResponseStatus(HttpStatus.OK)
    public EnderecoDto getByCep(@PathVariable(value = "cep") String cep) {
        EnderecoDto enderecoDto = enderecoService.findByCep(cep);

        if (enderecoDto.getLogradouro() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, MessageUtils.getMessage("endereco.cep.cepNaoEncontrado"));
        }

        return enderecoDto;
    }
}
