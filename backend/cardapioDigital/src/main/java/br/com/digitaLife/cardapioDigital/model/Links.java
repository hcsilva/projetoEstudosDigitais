package br.com.digitaLife.cardapioDigital.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "LINKS")
public class Links extends VersionedEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EMPRESA")
    private Empresa empresa;

    @Column(name = "DESCRICAO", length = 300)
    private String descricao;

    @Column(name = "LINK", length = 100)
    private String link;

}
