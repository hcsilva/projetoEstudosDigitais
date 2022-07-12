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
@Table(name = "LINKS")
public class Links extends VersionedEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_EMPRESA")
    private Empresa empresa;

    @Column(name = "DESCRICAO", length = 300)
    private String descricao;

    @Column(name = "LINK", length = 100)
    private String link;

}
