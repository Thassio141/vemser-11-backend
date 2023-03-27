package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContatoCreateDTO {
    @Schema(description = "ID da pessoa" , example = "123" , required = true)
    private Integer idPessoa;
    @NotNull
    @Schema(description = "Tipo do Contato" , example = "COMERCIAL" , required = true)
    private TipoContato tipoContato;
    @NotNull
    @Size(max=13)
    @Schema(description = "Numero do Contato" , example = "998482992" , required = true)
    private String numero;

    @NotNull
    @NotBlank
    @Schema(description = "Descrição do contato" , example = "texto da descrição" , required = true)
    private String descricao;


}
