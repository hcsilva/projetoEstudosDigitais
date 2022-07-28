package br.com.digitaLife.cardapioDigital.service;

import br.com.digitaLife.cardapioDigital.exceptions.ObjectNotFoundException;
import br.com.digitaLife.cardapioDigital.model.Categoria;
import br.com.digitaLife.cardapioDigital.model.ItemCategoria;
import br.com.digitaLife.cardapioDigital.repository.CategoriaRepository;
import br.com.digitaLife.cardapioDigital.repository.ItemCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemCategoriaService {

    @Autowired
    private ItemCategoriaRepository itemCategoriaRepository;

    @Transactional
    public ItemCategoria save(ItemCategoria itemCategoria) {
        return itemCategoriaRepository.save(itemCategoria);
    }

    @Transactional(readOnly = true)
    public Page<ItemCategoria> findAll(Pageable pageable) {
        return itemCategoriaRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public ItemCategoria findById(Long id) {
        return itemCategoriaRepository.findById(id)
                .orElseThrow(
                        () -> new ObjectNotFoundException("itemCategoria.naoEncontrado")
                );
    }

    @Transactional
    public void delete(ItemCategoria itemCategoria) {
        itemCategoriaRepository.delete(itemCategoria);
    }
}
