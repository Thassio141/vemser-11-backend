package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Pessoa_X_Filme")
public class PessoaFilmeEntity{
    @EmbeddedId
    @Column(name = "pessoaFilmeID")
    private PessoaFilmeID pessoaFilmeID;
    @Column(name = "dt_assistido")
    private LocalDate dtAssistido;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "nota_pessoa")
    private Integer notaPessoa;


    @ManyToOne(fetch= FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "id_pessoa" , referencedColumnName = "id_pessoa" , insertable = false, updatable = false)
    private PessoaEntity pessoaEntity;

    @ManyToOne(fetch= FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "id_filme" , referencedColumnName = "id_filme" ,insertable = false, updatable = false)
    private FilmeEntity filmeEntity;
}
