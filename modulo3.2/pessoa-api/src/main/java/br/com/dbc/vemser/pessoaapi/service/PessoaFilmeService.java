package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaFilmeCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaFilmeDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaFilmeEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaFilmeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PessoaFilmeService {

    private final PessoaFilmeRepository pessoaFilmeRepository;

    private final ObjectMapper objectMapper;

    public PessoaFilmeService(PessoaFilmeRepository pessoaFilmeRepository, ObjectMapper objectMapper) {
        this.pessoaFilmeRepository = pessoaFilmeRepository;
        this.objectMapper = objectMapper;
    }

    private PessoaFilmeDTO create(PessoaFilmeCreateDTO pessoaFilme) throws Exception {
        PessoaFilmeEntity pessoaFilmeEntity = objectMapper.convertValue(pessoaFilme, PessoaFilmeEntity.class);
        PessoaFilmeEntity pessoaFilmeCriado = pessoaFilmeRepository.save(pessoaFilmeEntity);
        PessoaFilmeDTO pessoaFilmeDTO = objectMapper.convertValue(pessoaFilmeCriado, PessoaFilmeDTO.class);
        return pessoaFilmeDTO;
    }

    public List<PessoaFilmeDTO> list(){
        return pessoaFilmeRepository.findAll()
                .stream()
                .map(filme -> objectMapper.convertValue(filme, PessoaFilmeDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaFilmeDTO update(Integer id, PessoaFilmeCreateDTO pessoaFilmeAtualizar) throws Exception {
        PessoaFilmeEntity pessoaFilmeRecuperado = getPessoaFilme(id);
        pessoaFilmeRecuperado.setDescricao(pessoaFilmeAtualizar.getDescricao());
        pessoaFilmeRecuperado.setNotaPessoa(pessoaFilmeAtualizar.getNotaPessoa());
        pessoaFilmeRecuperado.setDtAssistido(pessoaFilmeAtualizar.getDtAssistido());
        return objectMapper.convertValue(pessoaFilmeRecuperado, PessoaFilmeDTO.class);
    }

    public void delete(Integer id) throws Exception {
        PessoaFilmeEntity pessoaFilmeRecuperado = getPessoaFilme(id);
        pessoaFilmeRepository.delete(pessoaFilmeRecuperado);
    }

    public List<PessoaFilmeEntity> listByIdPessoaFilme(Integer idPessoaFilme) throws RegraDeNegocioException {

        List<PessoaFilmeEntity> pessoaFilmeEntity = new ArrayList<>();
        if (pessoaFilmeEntity.isEmpty()){
            throw new RegraDeNegocioException("Nenhum filme ou Pessoa encontrado" + idPessoaFilme);
        }
        return pessoaFilmeEntity;
    }

    private PessoaFilmeEntity getPessoaFilme(Integer id) throws RegraDeNegocioException {
        PessoaFilmeEntity pessoaFilmeRecuperado = pessoaFilmeRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa e/ou Filme não encontrado"));
        return pessoaFilmeRecuperado;
    }
}

