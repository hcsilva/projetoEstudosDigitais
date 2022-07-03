package br.com.digitaLife.cardapioDigital.service;

import br.com.digitaLife.cardapioDigital.dto.CepDto;
import br.com.digitaLife.cardapioDigital.dto.EnderecoDto;
import br.com.digitaLife.cardapioDigital.exceptions.BadRequestException;
import br.com.digitaLife.cardapioDigital.model.Endereco;
import br.com.digitaLife.cardapioDigital.repository.EnderecoRepository;
import br.com.digitaLife.cardapioDigital.utils.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Transactional
public class EnderecoService {

    private static final String URL_BASE_VIA_CEP = "https://viacep.com.br/ws/%s/json/";

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Transactional(readOnly = true)
    public Page<Endereco> findAll(Pageable pageable) {
        return enderecoRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Optional<Endereco> findById(Long id) {
        return enderecoRepository.findById(id);
    }


    public void delete(Endereco endereco) {
        enderecoRepository.delete(endereco);
    }

    public EnderecoDto carregarDadosPeloCep(String cep) {
        validateCep(cep);
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(URL_BASE_VIA_CEP, cep);
        CepDto response = restTemplate.getForObject(url, CepDto.class);

        if (response == null) {
            ExceptionUtils.throwsErrorExceptionMessage("endereco.cep.cepNaoEncontrado");
        }

        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setBairro(response.getBairro());
        enderecoDto.setComplemento(response.getComplemento());
        enderecoDto.setEstado(response.getUf());
        enderecoDto.setCidade(response.getLocalidade());
        enderecoDto.setLogradouro(response.getLogradouro());
        enderecoDto.setCep(cep);

        return enderecoDto;
    }


    private void validateCep(String cep) {
        if (StringUtils.isEmpty(cep)) {
            ExceptionUtils.throwsErrorExceptionMessage("endereco.cep.cepDeveEstarPreenchido");
        }

        if (cep.trim().length() != 8) {
            ExceptionUtils.throwsErrorExceptionMessage("endereco.cep.tamanhoMaximoExcedido");
        }
    }

}
