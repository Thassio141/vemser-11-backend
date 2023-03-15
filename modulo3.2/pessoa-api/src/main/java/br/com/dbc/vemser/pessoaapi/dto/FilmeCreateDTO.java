package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoFilme;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
public class FilmeCreateDTO {

    @NotNull
    @NotBlank
    @Schema(description = "Nota do filme" , example = "9" , required = true)
    private Integer nota;

    @NotBlank
    @Schema(description = "Descricao do filme" , example = "texto de descricao" , required = true)
    private String descricao;

    @NotNull
    @NotBlank
    @Schema(description = "Tipo do Filme" , example = "Misterio" , required = true)
    private TipoFilme tipo;
}
