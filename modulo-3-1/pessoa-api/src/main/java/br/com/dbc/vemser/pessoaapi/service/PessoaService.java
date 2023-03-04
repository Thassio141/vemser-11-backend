package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    private final ObjectMapper objectMapper;

    public PessoaService(PessoaRepository pessoaRepository, ObjectMapper objectMapper){
        this.pessoaRepository = pessoaRepository;
        this.objectMapper = objectMapper;
    }

    public PessoaDTO create(PessoaCreateDTO pessoa) throws Exception {

        Pessoa pessoaEntity = objectMapper.convertValue(pessoa,Pessoa.class);
        Pessoa pessoaCriada = pessoaRepository.create(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);
        return pessoaDTO;
    }

    public List<PessoaDTO> list(){
        return pessoaRepository.list()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        Pessoa pessoaRecuperada = getPessoa(id);

        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());

        return objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);
    }

    public void delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = getPessoa(id);
        pessoaRepository.delete(pessoaRecuperada);
    }

    public List<PessoaDTO> listByName(String nome) {
        List<Pessoa> pessoaNome = pessoaRepository.listByName(nome);

        return pessoaNome
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public Pessoa getPessoa(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));

    }

//    public void validarPessoa(Pessoa pessoa) throws Exception {
//        if (StringUtils.isBlank(pessoa.getNome())){
//            throw new Exception("Nome da pessoa em branco!");
//        }
//        if (ObjectUtils.isEmpty(pessoa.getDataNascimento())){
//            throw new Exception("Data de nascimento está vazio!");
//        }
//        if (StringUtils.isBlank(pessoa.getCpf()) || pessoa.getCpf().length() != 11) {
//            throw new Exception("CPF está em branco ou não possui 11 digitos!");
//        }
//    }
}
