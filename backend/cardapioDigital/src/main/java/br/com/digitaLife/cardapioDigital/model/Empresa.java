package br.com.digitaLife.cardapioDigital.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "EMPRESA")
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "razao_social", length = 150)
    private String razaoSocial;

    @Column(name = "cnpj")
    private Integer cnpj;

    @Column(name = "logo")
    @Lob
    private byte[] logo;

    @Column(name = "imagem_capa")
    @Lob
    private byte[] imagemCapa;

    @Column(name = "descricao", length = 300)
    private String descricao;

    @Column(name = "site", length = 100)
    private String site;

    @Column(name = "instagram", length = 100)
    private String instagram;

    @Column(name = "facebook", length = 100)
    private String facebook;

    @Column(name = "whatsapp", length = 20)
    private String whatsapp;

    @NotNull
    @Column(name = "telefone_contato", length = 100)
    private String telefoneContato;

    @NotNull
    @Column(name = "email", length = 50)
    private String email;

    @NotNull
    @Column(name = "idioma", length = 5)
    private String idioma;

    @NotNull
    @Column(name = "fuso", length = 10)
    private String fusoHorario;

    public Empresa() {
        this.idioma = "pt-BR";
        this.fusoHorario = "Z";
    }
}
