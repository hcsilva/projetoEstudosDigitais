package br.com.digitaLife.cardapioDigital.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "EMPRESA")
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "RAZAO_SOCIAL", length = 150)
    private String razaoSocial;

    @Column(name = "CNPJ")
    private Integer cnpj;

    @Column(name = "LOGO")
    @Lob
    private byte[] logo;

    @Column(name = "IMAGEM_CAPA")
    @Lob
    private byte[] imagemCapa;

    @Column(name = "DESCRICAO", length = 300)
    private String descricao;

    @Column(name = "SITE", length = 100)
    private String site;

    @Column(name = "INSTAGRAM", length = 100)
    private String instagram;

    @Column(name = "FACEBOOK", length = 100)
    private String facebook;

    @Column(name = "WHATSAPP", length = 20)
    private String whatsapp;

    @NotNull
    @Column(name = "TELEFONE_CONTATO", length = 100)
    private String telefoneContato;

    @NotNull
    @Column(name = "EMAIL", length = 50)
    private String email;

    @NotNull
    @Column(name = "IDIOMA", length = 5)
    private String idioma;

    @NotNull
    @Column(name = "FUSO", length = 10)
    private String fusoHorario;

    @NotNull
    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacaoRegistro;

    public Empresa() {
        this.idioma = "pt-BR";
        this.fusoHorario = "Z";
    }
}
