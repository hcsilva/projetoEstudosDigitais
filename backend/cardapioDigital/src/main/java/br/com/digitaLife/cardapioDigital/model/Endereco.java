package br.com.digitaLife.cardapioDigital.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ENDERECO")
public class Endereco extends VersionedEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID")
    private Empresa empresa;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "NUMERO")
    private int numero;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "CEP")
    private int cep;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "PAIS")
    private String pais;

}
