package br.com.digitaLife.cardapioDigital.service;

import br.com.digitaLife.cardapioDigital.exceptions.ObjectNotFoundException;
import br.com.digitaLife.cardapioDigital.model.HorarioFuncionamento;
import br.com.digitaLife.cardapioDigital.repository.HorarioFuncionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HorarioFuncionamentoService {

    @Autowired
    private HorarioFuncionamentoRepository horarioFuncionamentoRepository;

    @Transactional
    public HorarioFuncionamento save(HorarioFuncionamento HorarioFuncionamento) {
        return horarioFuncionamentoRepository.save(HorarioFuncionamento);
    }

    @Transactional(readOnly = true)
    public Page<HorarioFuncionamento> findAll(Pageable pageable) {
        return horarioFuncionamentoRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public HorarioFuncionamento findById(Long id) {
        return horarioFuncionamentoRepository.findById(id)
                .orElseThrow(
                        () -> new ObjectNotFoundException("horarioFuncionamento.naoEncontrado")
                );
    }

    @Transactional
    public void delete(HorarioFuncionamento horarioFuncionamento) {
        horarioFuncionamentoRepository.delete(horarioFuncionamento);
    }
}
