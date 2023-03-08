package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor

@Data
public class PessoaCreateDTO {

    @NotNull
    @NotBlank
    @Schema(description = "Nome da pessoa" , example = "Maria" , required = true)
    private String nome;
    @NotNull
    @Past
    @Schema(description = "Data de Nascimento da pessoa" , example = "11/09/2001" , required = true)
    private LocalDate dataNascimento;
    @NotNull
    @NotBlank
    @Size(min = 11, max = 11,  message = "cpf deve conter 11 caracteres")
    @Schema(description = "CPF da pessoa" , example = "011.223.444-55" , required = true)
    private String cpf;

    @Schema(description = "Email da pessoa" , example = "thassio@gmail.com" , required = true)
    private String email;
}
