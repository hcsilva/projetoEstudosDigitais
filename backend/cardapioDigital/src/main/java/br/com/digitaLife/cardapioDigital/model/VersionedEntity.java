package br.com.digitaLife.cardapioDigital.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class VersionedEntity {

    @JsonFormat(pattern = "dd/MM/yyyy hh:MM:ss")
    @Column(name = "DATA_ALTERACAO")
    private LocalDateTime dataCriacaoRegistro;


    @JsonFormat(pattern = "dd/MM/yyyy hh:MM:ss")
    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataModificacaoRegistro;

}
