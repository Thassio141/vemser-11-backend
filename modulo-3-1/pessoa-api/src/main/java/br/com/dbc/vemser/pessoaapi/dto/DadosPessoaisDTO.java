package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DadosPessoaisDTO {

    @NotBlank
    String nome;
    @NotBlank
    String cpf;
    @NotBlank
    String cnh;
    @NotBlank
    String nomeMae;
    @NotBlank
    String nomePai;
    @NotBlank
    String tituloEleitor;
    @NotNull
    Sexo sexo;
}
