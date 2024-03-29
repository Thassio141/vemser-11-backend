package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {
    private Integer idEndereco;
    private Integer idPessoa;

    private TipoEndereco tipo;

    private String logradouro;

    private Integer numero;
    private String complemento;

    private String cep;

    private String cidade;

    private String estado;

    private String pais;
}
