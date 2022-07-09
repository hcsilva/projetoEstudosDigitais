package br.com.digitaLife.cardapioDigital.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "HORARIO_FUNCIONAMENTO")
public class HorarioFuncionamento extends VersionedEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @Column(name = "SEGUNDA_INI")
    private LocalTime segundaInicial;

    @Column(name = "SEGUNDA_FIM")
    private LocalTime segundafinal;

    @Column(name = "SEGUNDA_INI_2")
    private LocalTime segundaInicial2;

    @Column(name = "SEGUNDA_FIM_2")
    private LocalTime segundafinal2;

    @Column(name = "TERCA_INI")
    private LocalTime tercaInicial;

    @Column(name = "TERCA_FIM")
    private LocalTime tercafinal;

    @Column(name = "TERCA_INI_2")
    private LocalTime tercaInicial2;

    @Column(name = "TERCA_FIM_2")
    private LocalTime tercaFinal2;

    @Column(name = "QUARTA_INI")
    private LocalTime quartaInicial;

    @Column(name = "QUARTA_FIM")
    private LocalTime quartafinal;

    @Column(name = "QUARTA_INI_2")
    private LocalTime quartaInicial2;

    @Column(name = "QUARTA_FIM_2")
    private LocalTime quartaFinal2;

    @Column(name = "QUINTA_INI")
    private LocalTime quintaInicial;

    @Column(name = "QUINTA_FIM")
    private LocalTime quintafinal;

    @Column(name = "QUINTA_INI_2")
    private LocalTime quintaInicial2;

    @Column(name = "QUINTA_FIM_2")
    private LocalTime quintaFinal2;

    @Column(name = "SEXTA_INI")
    private LocalTime sextaInicial;

    @Column(name = "SEXTA_FIM")
    private LocalTime sextafinal;

    @Column(name = "SEXTA_INI_2")
    private LocalTime sextaInicial2;

    @Column(name = "SEXTA_FIM_2")
    private LocalTime sextaFinal2;

    @Column(name = "SABADO_INI")
    private LocalTime sabadoInicial;

    @Column(name = "SABADO_FIM")
    private LocalTime sabadofinal;

    @Column(name = "SABADO_INI_2")
    private LocalTime sabadoInicial2;

    @Column(name = "SABADO_FIM_2")
    private LocalTime sabadoFinal2;

    @Column(name = "DOMINGO_INI")
    private LocalTime domingoInicial;

    @Column(name = "DOMINGO_FIM")
    private LocalTime domingofinal;

    @Column(name = "DOMINGO_INI_2")
    private LocalTime domingoInicial2;

    @Column(name = "DOMINGO_FIM_2")
    private LocalTime domingoFinal2;


}
