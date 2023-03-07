package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import br.com.dbc.vemser.pessoaapi.service.PropertieReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Validated
@Slf4j
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
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname") // GET localhost:8080/pessoa/byname?nome=Rafa
    public ResponseEntity<List<PessoaDTO>> listByName(@RequestParam("nome") @NotBlank String nome) {
        return new ResponseEntity<>(pessoaService.listByName(nome), HttpStatus.OK);
    }

    @PostMapping // POST localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {
        log.info("Pessoa criando..");
        PessoaDTO p = pessoaService.create(pessoa);
        log.info("Pessoa criada!");
        return new ResponseEntity<>(pessoaService.create(p), HttpStatus.OK);
    }

    @PutMapping("/{idPessoa}") // PUT localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id, @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        return new ResponseEntity<>(pessoaService.update(id,pessoaAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/ambiente")
    public String ambiente(){
        return propertieReader.getAmbiente();
    }
}
