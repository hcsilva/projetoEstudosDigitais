package br.com.digitaLife.cardapioDigital.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class VersionedEntity<Object> {

    @JsonFormat(pattern = "dd/MM/yyyy hh:MM:ss")
    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacaoRegistro;

    @JsonFormat(pattern = "dd/MM/yyyy hh:MM:ss")
    @Column(name = "DATA_ALTERACAO")
    private LocalDateTime dataModificacaoRegistro;

    @PrePersist
    public void carregarValoresDateBeforeSaveNewRegister() {
        this.dataCriacaoRegistro = LocalDateTime.now();
    }

    @PreUpdate
    public void carregarValoresDateBeforeUpdate() {
        this.dataModificacaoRegistro = LocalDateTime.now();
    }

}
