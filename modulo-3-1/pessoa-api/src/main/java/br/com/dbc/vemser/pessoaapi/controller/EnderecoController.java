package br.com.dbc.vemser.pessoaapi.controller;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<Endereco> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public List<Endereco> listByIdEndereco(@PathVariable("idEndereco") Integer idEndereco) {
        return enderecoService.listByIdEndereco(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return enderecoService.listByIdEndereco(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Endereco> create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody @Valid Endereco endereco) throws Exception {
        return new ResponseEntity<>(enderecoService.create(idPessoa, endereco), HttpStatus.OK);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> update(@PathVariable("idEndereco") Integer id, @RequestBody @Valid Endereco enderecoAtualizar) throws Exception {
        return new ResponseEntity<>(enderecoService.update(id, enderecoAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> delete() throws Exception {
        return ResponseEntity.ok().build();
    }
}