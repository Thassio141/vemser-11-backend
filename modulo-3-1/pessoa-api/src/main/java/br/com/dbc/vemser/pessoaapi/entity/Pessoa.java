package br.com.dbc.vemser.pessoaapi.entity;

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
public class Pessoa {

    private Integer idPessoa;
    @NotNull
    @NotBlank
    private String nome;
    @NotNull
    @Past
    private LocalDate dataNascimento;
    @NotNull
    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;
}
