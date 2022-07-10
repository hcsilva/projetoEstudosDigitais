package br.com.digitaLife.cardapioDigital.service;

import br.com.digitaLife.cardapioDigital.exceptions.ObjectNotFoundException;
import br.com.digitaLife.cardapioDigital.model.Empresa;
import br.com.digitaLife.cardapioDigital.model.Links;
import br.com.digitaLife.cardapioDigital.repository.EmpresaRepository;
import br.com.digitaLife.cardapioDigital.repository.LinksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LinksService {

    @Autowired
    private LinksRepository linksRepository;

    @Transactional
    public Links save(Links links) {
        return linksRepository.save(links);
    }

    @Transactional(readOnly = true)
    public Page<Links> findAll(Pageable pageable) {
        return linksRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Links findById(Long id) {
        return linksRepository.findById(id)
                .orElseThrow(
                        () -> new ObjectNotFoundException("links.naoEncontrado")
                );
    }

    public void delete(Links links) {
        linksRepository.delete(links);
    }

}
