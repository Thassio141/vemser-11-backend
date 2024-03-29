package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PessoaDTO extends PessoaCreateDTO{
    @Schema(description = "Id da Pessoa" , example = "1" , required = true)
    private Integer idPessoa;
}
