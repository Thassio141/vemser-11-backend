package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoCreateDTO {
    private Integer idPessoa;
    @NotNull
    private TipoEndereco tipo;
    @NotBlank
    @Size(max=250)
    private String logradouro;
    @NotNull
    private Integer numero;
    private String complemento;
    @NotNull
    @NotBlank
    @Size(max=8)
    private String cep;
    @NotBlank
    @NotNull
    @Size(max=250)
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String pais;
}
