package br.com.dbc.vemser.pessoaapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class PessoaFilmeCreateDTO {

    @Column(name = "id_filme")
    private Integer idFilme;
    @Column(name = "dt_assistido")
    private LocalDate dtAssistido;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "nota_pessoa")
    private Integer notaPessoa;
}
