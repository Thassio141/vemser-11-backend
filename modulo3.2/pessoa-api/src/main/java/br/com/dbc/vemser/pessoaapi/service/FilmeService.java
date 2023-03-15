package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.FilmeCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.FilmeDTO;
import br.com.dbc.vemser.pessoaapi.entity.FilmeEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.FilmeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;
    private final ObjectMapper objectMapper;

    public FilmeService(FilmeRepository filmeRepository, ObjectMapper objectMapper) {
        this.filmeRepository = filmeRepository;
        this.objectMapper = objectMapper;
    }

    public FilmeDTO create(FilmeCreateDTO filme) throws Exception {
        FilmeEntity filmeEntity = objectMapper.convertValue(filme, FilmeEntity.class);
        FilmeEntity filmeCriado = filmeRepository.save(filmeEntity);
        FilmeDTO filmeDTO = objectMapper.convertValue(filmeCriado, FilmeDTO.class);
        return filmeDTO;
    }

    public List<FilmeDTO> list(){
        return filmeRepository.findAll()
                .stream()
                .map(filme -> objectMapper.convertValue(filme, FilmeDTO.class))
                .collect(Collectors.toList());
    }

    public FilmeDTO update(Integer id, FilmeCreateDTO filmeAtualizar) throws Exception {
        FilmeEntity filmeRecuperado = getFilme(id);
        filmeRecuperado.setTipoFilme(filmeAtualizar.getTipo());
        filmeRecuperado.setDescricao(filmeAtualizar.getDescricao());
        filmeRecuperado.setNota(filmeAtualizar.getNota());
        return objectMapper.convertValue(filmeRecuperado, FilmeDTO.class);
    }

    public void delete(Integer id) throws Exception {
        FilmeEntity filmeRecuperado = getFilme(id);
        filmeRepository.delete(filmeRecuperado);
    }

    public List<FilmeEntity> listByIdFilme(Integer idFilme) throws RegraDeNegocioException {

        List<FilmeEntity> filmeEntity = new ArrayList<>();
        if (filmeEntity.isEmpty()){
            throw new RegraDeNegocioException("Nenhum filme encontrado" + idFilme);
        }
        return filmeEntity;
    }

    private FilmeEntity getFilme(Integer id) throws RegraDeNegocioException {
        FilmeEntity filmeRecuperado = filmeRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não encontrado"));
        return filmeRecuperado;
    }
}
