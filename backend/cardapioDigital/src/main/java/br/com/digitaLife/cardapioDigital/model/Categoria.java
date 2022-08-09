package br.com.digitaLife.cardapioDigital.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CATEGORIA")
public class Categoria extends VersionedEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA")
    private Empresa empresa;

    @Column(name = "DESCRICAO", length = 100)
    private String descricao;

    @Column(name = "DESCRICAO_DETALHADA", length = 250)
    private String descricaoDetalhada;

    @Column(name = "LABEL_MINI_PRATO", length = 30)
    private String labelMiniPrato;

    @Column(name = "STATUS")
    private boolean status;

}
