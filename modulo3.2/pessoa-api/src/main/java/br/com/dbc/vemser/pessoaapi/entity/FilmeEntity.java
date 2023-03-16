package br.com.dbc.vemser.pessoaapi.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

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
    private Integer idFilme;
    @Column(name = "descricao")
    private String descricaoFilme;
    @Column(name = "notaFilme")
    private Integer notaFilme;
    @Column(name = "tipo")
    private TipoFilme tipoFilme;

    @OneToMany(fetch= FetchType.LAZY, mappedBy = "filmeEntity" )
    @JsonIgnore
    private Set<PessoaFilmeEntity> pessoaFilmeEntity;

}
