package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;

import br.com.dbc.vemser.pessoaapi.service.DadosPessoaisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/dados-pessoais")
public class DadosPessoaisController implements DadosPessoaisInterface{

    private final DadosPessoaisService dadosPessoaisService;

    @GetMapping
    public ResponseEntity<List<DadosPessoaisDTO>> listDadosPessoas(){
        return new ResponseEntity<>(dadosPessoaisService.listDadosPessoais(), HttpStatus.OK);
    }

    @PostMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> create( @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception{
        return new ResponseEntity<>(dadosPessoaisService.create(dadosPessoaisDTO), HttpStatus.OK);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> update( @PathVariable("cpf") String cpf, @RequestBody DadosPessoaisDTO dto) throws Exception{
        return new ResponseEntity<>(dadosPessoaisService.update(cpf, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{cpf}")
    public  ResponseEntity<Void> delete(@PathVariable("cpf") String cpf){
        dadosPessoaisService.delete(cpf);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> getByCPF(@PathVariable("cpf") String cpf){
        return new ResponseEntity<>(dadosPessoaisService.getByCPF(cpf), HttpStatus.OK);
    }
}
