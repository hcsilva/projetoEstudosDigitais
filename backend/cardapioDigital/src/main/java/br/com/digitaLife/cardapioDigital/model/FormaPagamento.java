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
@Table(name = "FORMA_PAGAMENTO")
public class FormaPagamento extends VersionedEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA")
    private Empresa empresa;

    @Column(name = "DINHEIRO")
    private boolean dinheiro;

    @Column(name = "CARTAO_CREDITO")
    private boolean cartaoCredito;

    @Column(name = "CARTAO_DEBITO")
    private boolean cartaoDebito;

    @Column(name = "VALE_REFEICAO")
    private boolean valeRefeicao;

    @Column(name = "VISIVEL")
    private boolean visivel;

}
