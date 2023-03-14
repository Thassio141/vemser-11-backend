package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

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
        ContatoEntity contatoEntityCriado = contatoRepository.create(contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntityCriado, ContatoDTO.class);
        return contatoDTO;
    }

    public List<ContatoDTO> list(){
        return contatoRepository.list()
                .stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizar) throws Exception {
        pessoaService.getPessoa(contatoAtualizar.getIdPessoa());
        ContatoEntity contatoEntityRecuperado = getContato(id);
        contatoEntityRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoEntityRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoEntityRecuperado.setDescricao(contatoAtualizar.getDescricao());

        return objectMapper.convertValue(contatoEntityRecuperado, ContatoDTO.class);
    }

    public void delete(Integer id) throws Exception {
        ContatoEntity contatoEntityRecuperado = getContato(id);
        contatoRepository.delete(contatoEntityRecuperado);
    }

    public List<ContatoDTO> listByIdPessoa(Integer idPessoa) {
        List<ContatoEntity> contatoEntityIdPessoa = contatoRepository.listByIdPessoa(idPessoa);

        return contatoEntityIdPessoa
                .stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    private ContatoEntity getContato(Integer id) throws RegraDeNegocioException {
        return contatoRepository.list().stream()
                .filter(contatoEntity -> contatoEntity.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() ->  new RegraDeNegocioException("Contato não encontrada!"));
    }
}
