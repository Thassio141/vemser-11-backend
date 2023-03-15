package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    private final ObjectMapper objectMapper;

    private final PessoaService pessoaService;

    public ContatoService(ContatoRepository contatoRepository, ObjectMapper objectMapper, PessoaService pessoaService){
        this.contatoRepository = contatoRepository;
        this.objectMapper = objectMapper;
        this.pessoaService = pessoaService;
    }

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato) throws Exception {
        contato.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());
        ContatoEntity contatoEntity = objectMapper.convertValue(contato, ContatoEntity.class);
        ContatoEntity contatoCriado = contatoRepository.save(contatoEntity);

        ContatoDTO contatoDTO = objectMapper.convertValue(contatoCriado, ContatoDTO.class);
        return contatoDTO;
    }

    public List<ContatoDTO> list(){
        return contatoRepository.findAll()
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizar) throws Exception {
        ContatoEntity contatoRecuperado = getContato(id);
        PessoaEntity pessoa = pessoaService.getPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperado.setPessoa(pessoa);
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());

        return objectMapper.convertValue(contatoRecuperado, ContatoDTO.class);
    }

    public void delete(Integer id) throws Exception {
        ContatoEntity contatoEntityRecuperado = getContato(id);
        contatoRepository.delete(contatoEntityRecuperado);
    }

    public List<ContatoEntity> listByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {

        List<ContatoEntity> contatoEntityIdPessoa = new ArrayList<>();
        if (contatoEntityIdPessoa.isEmpty()){
            throw new RegraDeNegocioException("Nenhum contato encontrado" + idPessoa);
        }
        return contatoEntityIdPessoa;
    }

    private ContatoEntity getContato(Integer id) throws RegraDeNegocioException {
        ContatoEntity contatoRecuperado = contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
        return contatoRecuperado;
    }
}
