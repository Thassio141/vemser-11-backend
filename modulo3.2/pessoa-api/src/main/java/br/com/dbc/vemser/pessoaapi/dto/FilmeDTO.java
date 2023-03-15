package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FilmeDTO extends FilmeCreateDTO{
    @Schema(description = "id do filme" , example = "123" , required = true)
    private String idFilme;
}
