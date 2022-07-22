package br.com.digitaLife.cardapioDigital.service;

import br.com.digitaLife.cardapioDigital.exceptions.ObjectNotFoundException;
import br.com.digitaLife.cardapioDigital.model.Categoria;
import br.com.digitaLife.cardapioDigital.model.FormaPagamento;
import br.com.digitaLife.cardapioDigital.repository.CategoriaRepository;
import br.com.digitaLife.cardapioDigital.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Transactional
    public FormaPagamento save(FormaPagamento formaPagamento) {
        return formaPagamentoRepository.save(formaPagamento);
    }

    @Transactional(readOnly = true)
    public Page<FormaPagamento> findAll(Pageable pageable) {
        return formaPagamentoRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public FormaPagamento findById(Long id) {
        return formaPagamentoRepository.findById(id)
                .orElseThrow(
                        () -> new ObjectNotFoundException("formaPagamento.naoEncontrado")
                );
    }

    @Transactional
    public void delete(FormaPagamento formaPagamento) {
        formaPagamentoRepository.delete(formaPagamento);
    }
}
