package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;

    private final ObjectMapper objectMapper;

    private final EmailService emailService;

    public EnderecoService(EnderecoRepository enderecoRepository, PessoaService pessoaService, ObjectMapper objectMapper, EmailService emailService) {
        this.enderecoRepository = enderecoRepository;
        this.pessoaService = pessoaService;
        this.objectMapper = objectMapper;
        this.emailService = emailService;
    }

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws Exception {
        PessoaEntity pessoaEntity = pessoaService.getPessoa(idPessoa);
        EnderecoEntity enderecoEntity = objectMapper.convertValue(endereco, EnderecoEntity.class);
        EnderecoEntity enderecoCriado = enderecoRepository.save(enderecoEntity);
        pessoaService.adicionarEndereco(enderecoCriado,pessoaEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);
        enderecoDTO.setIdPessoa(idPessoa);
        emailService.sendEmailEndereco(pessoaService.getPessoa(idPessoa), enderecoCriado, "1");
        return enderecoDTO;
    }

    public List<EnderecoDTO> list(){
        return enderecoRepository.findAll()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoAtualizar) throws Exception {
        PessoaEntity pessoa = pessoaService.getPessoa(enderecoAtualizar.getIdPessoa());

        EnderecoEntity enderecoRecuperado = getEndereco(id);
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());

        pessoaService.adicionarEndereco(enderecoRecuperado,pessoa);
        enderecoRepository.save(enderecoRecuperado);
        emailService.sendEmailEndereco(pessoaService.getPessoa(id), enderecoRecuperado, "2");
        return objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class);
    }

    public void delete(Integer id) throws Exception {
        EnderecoEntity enderecoRecuperado = getEndereco(id);
        emailService.sendEmailEndereco(pessoaService.getPessoa(id), enderecoRecuperado, "3");
        enderecoRepository.delete(enderecoRecuperado);
    }

    public EnderecoDTO getEnderecoDTO(Integer id) throws RegraDeNegocioException{
        return objectMapper.convertValue(getEndereco(id),EnderecoDTO.class);
    }

    public EnderecoEntity getEndereco(Integer id) throws RegraDeNegocioException {
        EnderecoEntity enderecoRecuperado = enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não encontrado"));
        return enderecoRecuperado;
    }

    public List<EnderecoDTO> listEnderecoDTO(Integer idPessoa) throws Exception {
        PessoaEntity pessoaEntity = pessoaService.getPessoa(idPessoa);
        return enderecoRepository.findAllByPessoa(pessoaEntity).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa,EnderecoDTO.class))
                        .toList();
    }
}
