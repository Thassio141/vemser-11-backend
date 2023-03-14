package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
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
        endereco.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());
        EnderecoEntity enderecoEntity = objectMapper.convertValue(endereco, EnderecoEntity.class);
        EnderecoEntity enderecoCriado = enderecoRepository.save(enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);
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
        pessoaService.getPessoa(enderecoAtualizar.getIdPessoa());
        EnderecoEntity enderecoRecuperado = getEndereco(id);
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());
        emailService.sendEmailEndereco(pessoaService.getPessoa(id), enderecoRecuperado, "2");
        return objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class);
    }

    public void delete(Integer id) throws Exception {
        EnderecoEntity enderecoRecuperado = getEndereco(id);
        emailService.sendEmailEndereco(pessoaService.getPessoa(id), enderecoRecuperado, "3");
        enderecoRepository.delete(enderecoRecuperado);
    }

    public List<EnderecoEntity> listByIdEndereco(Integer idEndereco) throws RegraDeNegocioException {

        List<EnderecoEntity> enderecoEntity = new ArrayList<>();
        if (enderecoEntity.isEmpty()){
            throw new RegraDeNegocioException("Nenhum endereco encontrado" + idEndereco);
        }
        return enderecoEntity;
    }

    private EnderecoEntity getEndereco(Integer id) throws RegraDeNegocioException {
        EnderecoEntity enderecoRecuperado = enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não encontrado"));
        return enderecoRecuperado;
    }
}
