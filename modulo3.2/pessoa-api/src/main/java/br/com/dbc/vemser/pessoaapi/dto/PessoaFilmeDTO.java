package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.PessoaFilmeID;
import lombok.Data;

@Data
public class PessoaFilmeDTO extends PessoaFilmeCreateDTO{
    private PessoaFilmeID pessoaFilmeID;
}
