package br.com.digitaLife.cardapioDigital.service;

import br.com.digitaLife.cardapioDigital.exceptions.ObjectNotFoundException;
import br.com.digitaLife.cardapioDigital.model.Empresa;
import br.com.digitaLife.cardapioDigital.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Transactional
    public Empresa save(Empresa empresa) {
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
