package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco create(Integer id, Endereco endereco){
        endereco.setIdPessoa(id);
        return enderecoRepository.create(endereco);
    }

    public List<Endereco> list(){
        return enderecoRepository.list();
    }

    public Endereco update(Integer id,
                           Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = getEndereco(id);

        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());
        return enderecoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Endereco enderecoRecuperado = getEndereco(id);
        enderecoRepository.delete(enderecoRecuperado);
    }

    public List<Endereco> listByIdEndereco(Integer idEndereco) {
        return enderecoRepository.listByIdEndereco(idEndereco);
    }

    private Endereco getEndereco(Integer id) throws Exception {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço inexistente!"));
    }
}
