package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

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
        Endereco enderecoEntity = objectMapper.convertValue(endereco, Endereco.class);
        Endereco enderecoCriado = enderecoRepository.create(enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);
        emailService.sendEmail(pessoaService.getPessoa(idPessoa));
        return enderecoDTO;
    }

    public List<EnderecoDTO> list(){
        return enderecoRepository.list()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoAtualizar) throws Exception {
        pessoaService.getPessoa(enderecoAtualizar.getIdPessoa());
        Endereco enderecoRecuperado = getEndereco(id);

        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());
        emailService.sendEmail(pessoaService.getPessoa(id));
        return objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class);
    }

    public void delete(Integer id) throws Exception {
        Endereco enderecoRecuperado = getEndereco(id);
        emailService.sendEmail(pessoaService.getPessoa(id));
        enderecoRepository.delete(enderecoRecuperado);
    }

    public List<EnderecoDTO> listByIdEndereco(Integer idEndereco) {
        List<Endereco> enderecoId = enderecoRepository.listByIdEndereco(idEndereco);

        return enderecoId
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    private Endereco getEndereco(Integer id) throws RegraDeNegocioException {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() ->  new RegraDeNegocioException("Endereço inexistente!"));
    }
}
