package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ContatoDTO extends ContatoCreateDTO{
    @Schema(description = "Id do Contato" , example = "1" , required = true)
    private Integer idContato;

}
