package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaFilmeID implements Serializable {
    @Column(name = "id_pessoa")
    private Integer idPessoa;
    @Column(name = "id_filme")
    private Integer idFilme;
}
