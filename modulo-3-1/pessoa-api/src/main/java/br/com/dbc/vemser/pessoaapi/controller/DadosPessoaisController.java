package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;

import feign.RequestLine;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dados-pessoais")
public class DadosPessoaisController {


    private final DadosPessoaisClient client;

    public DadosPessoaisController(DadosPessoaisClient client) {
        this.client = client;
    }

    @GetMapping
    public List<DadosPessoaisDTO> listDadosPessoais(){
        return client.getAll();
    }

    @PostMapping("/{cpf}")
    public DadosPessoaisDTO create( @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception{
        return client.post(dadosPessoaisDTO);
    }

    @PutMapping("/{cpf}")
    public DadosPessoaisDTO update( @PathVariable("cpf") String cpf, @RequestBody DadosPessoaisDTO dto) throws Exception{
        return client.put(cpf,dto);
    }

    @RequestLine("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf){
        client.delete(cpf);
    };
    @RequestLine("/{cpf}")
    public DadosPessoaisDTO getByCPF(@PathVariable("cpf") String cpf){
        return client.get(cpf);
    };
}
