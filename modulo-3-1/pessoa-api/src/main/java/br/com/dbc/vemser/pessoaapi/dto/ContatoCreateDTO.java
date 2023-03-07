package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
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
    private Integer idPessoa;
    @NotNull
    private TipoContato tipoContato;
    @NotNull
    @Size(max=13)
    private String numero;

    @NotNull
    @NotBlank
    private String descricao;


}
