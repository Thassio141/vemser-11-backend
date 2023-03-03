package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import br.com.dbc.vemser.pessoaapi.service.PropertieReader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Validated
public class PessoaController {

    private final PessoaService pessoaService;
    private final PropertieReader propertieReader;
    public PessoaController(PessoaService pessoaService, PropertieReader propertieReader) {
        this.pessoaService = pessoaService;
        this.propertieReader = propertieReader;
    }

    @GetMapping("/hello") // GET localhost:8080/pessoa/hello
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/hello-2") // GET localhost:8080/pessoa/hello2
    public String hello2() {
        return "Hello world 2!";
    }

    @GetMapping // GET localhost:8080/pessoa
    public List<Pessoa> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname") // GET localhost:8080/pessoa/byname?nome=Rafa
    public List<Pessoa> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @PostMapping // POST localhost:8080/pessoa
    public ResponseEntity<Pessoa> create(@RequestBody @Valid Pessoa pessoa) throws Exception {
        pessoaService.validarPessoa(pessoa);
        return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.OK);
    }

    @PutMapping("/{idPessoa}") // PUT localhost:8080/pessoa/1000
    public ResponseEntity<Pessoa> update(@PathVariable("idPessoa") Integer id,
                         @RequestBody @Valid Pessoa pessoaAtualizar) throws Exception {
        pessoaService.validarPessoa(pessoaAtualizar);
        return new ResponseEntity<>(pessoaService.update(id,pessoaAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idPessoa}") // DELETE localhost:8080/pessoa/10
    public ResponseEntity<Void> delete() throws Exception {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/ambiente")
    public String ambiente(){
        return propertieReader.getAmbiente();
    }
}
