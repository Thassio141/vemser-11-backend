package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface DadosPessoaisInterface {
    @Operation(summary = "Listar Dados Pessoais", description = "Listar Todos os Dados Pessoais do Banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de dados"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public ResponseEntity<List<DadosPessoaisDTO>> listDadosPessoas();

    @Operation(summary = "Criar dados pessoais", description = "Inserir dados pessoais no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a confirmação de criação dos dados pessoais"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @PostMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> create( @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception;

    @Operation(summary = "Editar dados pessoais", description = "Editar os dados pessoas banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a confirmação de edição dos dados pessoais"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> update(@PathVariable("cpf") String cpf, @RequestBody DadosPessoaisDTO dto) throws Exception;

    @Operation(summary = "Deletar dados pessoais", description = "Deletar dados pessoais do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a confirmação ao excluir os dados pessoais"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @DeleteMapping("/{cpf}")
    public  ResponseEntity<Void> delete(@PathVariable("cpf") String cpf);

    @Operation(summary = "Listar dados pessoais", description = "Listar dados pessoais pelo CPF da pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna os dados pessoais do cpf inserido"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> getByCPF(@PathVariable("cpf") String cpf);
}
