package br.com.digitaLife.cardapioDigital.service;

import br.com.digitaLife.cardapioDigital.exceptions.ObjectNotFoundException;
import br.com.digitaLife.cardapioDigital.model.Empresa;
import br.com.digitaLife.cardapioDigital.repository.EmpresaRepository;
import br.com.digitaLife.cardapioDigital.utils.ExceptionUtils;
import br.com.digitaLife.cardapioDigital.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Transactional
    public Empresa save(Empresa empresa) {
        empresa.setDataCriacaoRegistro(LocalDateTime.now());
        empresa.setDataModificacaoRegistro(LocalDateTime.now());
        return empresaRepository.save(empresa);
    }

    @Transactional(readOnly = true)
    public Page<Empresa> findAll(Pageable pageable) {
        return empresaRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Empresa findById(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(
                        () -> new ObjectNotFoundException("empresa.naoEncontrada")
                );
    }

    public void delete(Empresa empresa) {
        empresaRepository.delete(empresa);
    }

}
