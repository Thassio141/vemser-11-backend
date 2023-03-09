package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "Nome da Pessoa" , example = "Maria" , required = true)
    String nome;
    @NotBlank
    @Schema(description = "CPF da Pessoa" , example = "01122233344" , required = true)
    String cpf;
    @NotBlank
    @Schema(description = "Numero da CNH" , example = "01122233344" , required = true)
    String cnh;
    @NotBlank
    @Schema(description = "Nome da Mãe" , example = "Maria" , required = true)
    String nomeMae;
    @NotBlank
    @Schema(description = "Nome do Pai" , example = "Joao" , required = true)
    String nomePai;
    @NotBlank
    @Schema(description = "titulo de Eleitor" , example = "244422" , required = true)
    String tituloEleitor;
    @NotNull
    @Schema(description = "Sexo da Pessoa" , example = "M ou F" , required = true)
    Sexo sexo;
}
