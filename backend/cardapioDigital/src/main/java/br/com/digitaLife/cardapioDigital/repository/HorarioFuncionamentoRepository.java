package br.com.digitaLife.cardapioDigital.repository;

import br.com.digitaLife.cardapioDigital.model.HorarioFuncionamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioFuncionamentoRepository extends JpaRepository<HorarioFuncionamento, Long> {
}
