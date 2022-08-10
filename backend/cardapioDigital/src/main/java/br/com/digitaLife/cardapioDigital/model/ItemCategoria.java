package br.com.digitaLife.cardapioDigital.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "ITEM_CATEGORIA")
public class ItemCategoria extends VersionedEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA")
    private Empresa empresa;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA")
    private Categoria categoria;

    @Column(name = "FOTO")
    @Lob
    private byte[] foto;

    @Column(name = "DESCRICAO_DETALHADA", length = 250)
    private String descricaoDetalhada;

    @Column(name = "DESCRICAO_SIMPLES", length = 100)
    private String descricaoSimples;

    @Column(name = "PRECO")
    private BigDecimal preco;

    @Column(name = "PRECO_MINI_PRATO")
    private BigDecimal precoMiniPrato;

    @Column(name = "SERVE_QUANTIDADE_PESSOAS")
    private Integer serveQuantidadePessoas;

    @Column(name = "SEM_LACTOSE")
    private boolean semLactose;

    @Column(name = "VEGETARIANO")
    private boolean vegetariano;

    @Column(name = "SEM_GLUTEN")
    private boolean semGluten;

    @Column(name = "VEGANO")
    private boolean vegano;

    @Column(name = "DESTAQUE")
    private boolean destaque;

}
