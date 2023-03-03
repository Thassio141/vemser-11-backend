package br.com.dbc.vemser.pessoaapi.controller;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}")
    public List<Contato> listByIdEndereco(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Contato> create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody @Valid Contato contato) throws Exception {
        return new ResponseEntity<>(contatoService.create(idPessoa, contato), HttpStatus.OK);
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<Contato> update(@PathVariable("idContato") Integer id, @RequestBody @Valid Contato contatoAtualizar) throws Exception {
        return new ResponseEntity<>(contatoService.update(id, contatoAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete() {
        return ResponseEntity.ok().build();
    }
}