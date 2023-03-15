package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class PessoaFilmeCreateDTO {
    @Column(name = "dt_assistido")
    private LocalDate dtAssistido;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "nota_pessoa")
    private Integer notaPessoa;
}
