package br.com.dbc.vemser.pessoaapi.controller;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
public class EnderecoController {
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<EnderecoDTO> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public List<EnderecoDTO> listByIdEndereco(@PathVariable("idEndereco") Integer idEndereco) {
        return enderecoService.listByIdEndereco(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return enderecoService.listByIdEndereco(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer idPessoa, @RequestBody @Valid Endereco endereco) throws Exception {
        return new ResponseEntity<>(enderecoService.create(idPessoa, endereco), HttpStatus.OK);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id, @RequestBody @Valid Endereco enderecoAtualizar) throws Exception {
        return new ResponseEntity<>(enderecoService.update(id, enderecoAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> delete() throws Exception {
        return ResponseEntity.ok().build();
    }
}