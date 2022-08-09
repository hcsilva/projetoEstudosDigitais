package br.com.digitaLife.cardapioDigital.repository;

import br.com.digitaLife.cardapioDigital.model.ItemCategoria;
import br.com.digitaLife.cardapioDigital.model.ItemExtras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemExtrasRepository extends JpaRepository<ItemExtras, Long> {
}
