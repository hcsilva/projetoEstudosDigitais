package br.com.digitaLife.cardapioDigital.repository;

import br.com.digitaLife.cardapioDigital.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
