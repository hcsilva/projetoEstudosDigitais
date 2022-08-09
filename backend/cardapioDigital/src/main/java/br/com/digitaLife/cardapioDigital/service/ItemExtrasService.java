package br.com.digitaLife.cardapioDigital.service;

import br.com.digitaLife.cardapioDigital.exceptions.ObjectNotFoundException;
import br.com.digitaLife.cardapioDigital.model.ItemCategoria;
import br.com.digitaLife.cardapioDigital.model.ItemExtras;
import br.com.digitaLife.cardapioDigital.repository.ItemCategoriaRepository;
import br.com.digitaLife.cardapioDigital.repository.ItemExtrasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemExtrasService {

    @Autowired
    private ItemExtrasRepository itemExtrasRepository;

    @Transactional
    public ItemExtras save(ItemExtras itemExtras) {
        return itemExtrasRepository.save(itemExtras);
    }

    @Transactional(readOnly = true)
    public Page<ItemExtras> findAll(Pageable pageable) {
        return itemExtrasRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public ItemExtras findById(Long id) {
        return itemExtrasRepository.findById(id)
                .orElseThrow(
                        () -> new ObjectNotFoundException("itemExtras.naoEncontrado")
                );
    }

    @Transactional
    public void delete(ItemExtras itemExtras) {
        itemExtrasRepository.delete(itemExtras);
    }
}
