package br.com.dbc.vemser.pessoaapi.entity;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Filme")
public class FilmeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILME_SEQ")
    @SequenceGenerator(name = "FILME_SEQ", sequenceName = "seq_filme", allocationSize = 1)
    @Column(name = "id_filme")
    private Integer id_filme;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "nota")
    private Integer nota;
    @Column(name = "tipo")
    private TipoFilme tipoFilme;
}
