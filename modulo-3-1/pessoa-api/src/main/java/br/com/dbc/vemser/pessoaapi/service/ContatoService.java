package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    private final PessoaService pessoaService;

    public ContatoService(ContatoRepository contatoRepository, PessoaService pessoaService){
        this.contatoRepository = contatoRepository;
        this.pessoaService = pessoaService;
    }

    public Contato create(Integer id, Contato contato) throws Exception {
        pessoaService.getPessoa(id);
        contato.setIdPessoa(id);
        return contatoRepository.create(contato);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
        pessoaService.getPessoa(contatoAtualizar.getIdPessoa());
        Contato contatoRecuperado = getContato(id);
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());

        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = getContato(id);
        contatoRepository.delete(contatoRecuperado);
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return contatoRepository.listByIdPessoa(idPessoa);
    }

    private Contato getContato(Integer id) throws Exception {
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrada!"));
    }
}
