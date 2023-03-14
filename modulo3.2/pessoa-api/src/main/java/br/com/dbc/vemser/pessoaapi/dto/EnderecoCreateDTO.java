package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoCreateDTO {
    @Schema(description = "Id da pessoa" , example = "123" , required = true)
    private Integer idPessoa;

    @Schema(description = "Tipo do endereço" , example = "COMERCIAL" , required = true)
    private TipoEndereco tipo;
    @NotBlank
    @Size(max=250)
    @Schema(description = "Logradouro" , example = "Rua A" , required = true)
    private String logradouro;

    @Schema(description = "Numero do Endereço" , example = "109" , required = true)
    private Integer numero;

    @Schema(description = "Complemento do endereço" , example = "Casa" , required = true)
    private String complemento;

    @NotBlank
    @Size(max=8)
    @Schema(description = "CEP do endereço" , example = "49000-000" , required = true)
    private String cep;
    @NotBlank

    @Size(max=250)
    @Schema(description = "Nome da cidade" , example = "Aracaju" , required = true)
    private String cidade;


    @Schema(description = "Nome da estado" , example = "Sergipe" , required = true)
    private String estado;

    @Schema(description = "Nome da pais" , example = "Brasil" , required = true)
    private String pais;
}
