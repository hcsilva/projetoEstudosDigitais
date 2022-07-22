package br.com.digitaLife.cardapioDigital.repository;

import br.com.digitaLife.cardapioDigital.model.Categoria;
import br.com.digitaLife.cardapioDigital.model.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
}
