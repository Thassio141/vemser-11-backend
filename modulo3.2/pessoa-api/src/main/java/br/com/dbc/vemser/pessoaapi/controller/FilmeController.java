package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.entity.FilmeEntity;
import br.com.dbc.vemser.pessoaapi.service.FilmeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/filme")
@Validated
@Slf4j
@RequiredArgsConstructor
public class FilmeController {
    private final FilmeService filmeService;

    @GetMapping
    public ResponseEntity<List<FilmeDTO>> list() {
        return new ResponseEntity<>(filmeService.list(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<FilmeEntity>> listByIdFilme(@PathVariable("idFilme") Integer idFilme) throws Exception {
        return new ResponseEntity<>(filmeService.listByIdFilme(idFilme), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FilmeDTO> create(@RequestBody @Valid FilmeCreateDTO filme) throws Exception {
        return new ResponseEntity<>(filmeService.create(filme), HttpStatus.OK);
    }

    @PutMapping("/{idFilme}")
    public ResponseEntity<FilmeDTO> update(@PathVariable("idFilme") Integer id, @RequestBody @Valid FilmeCreateDTO filmeAtualizar) throws Exception {
        return new ResponseEntity<>(filmeService.update(id, filmeAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idFilme}")
    public ResponseEntity<Void> delete(@PathVariable Integer idFilme) throws Exception {
        filmeService.delete(idFilme);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/avaliar/{idUsuario}")
    public ResponseEntity<PessoaFilmeDTO> avaliar(@PathVariable("idUsuario") Integer idUsuario, @RequestBody @Valid PessoaFilmeCreateDTO pessoaFilmeCreateDTO) throws Exception{
        return new ResponseEntity<>(filmeService.avaliarFilme(idUsuario,pessoaFilmeCreateDTO), HttpStatus.OK);
    }
}