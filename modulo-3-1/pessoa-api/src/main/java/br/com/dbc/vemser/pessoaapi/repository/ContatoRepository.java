package br.com.dbc.vemser.pessoaapi.repository;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/,1, TipoContato.RESIDENCIAL,"198492999","descricao teste"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/,2, TipoContato.RESIDENCIAL,"298492999","descricao teste"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/,3, TipoContato.COMERCIAL,"398492999","descricao teste"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/,4, TipoContato.COMERCIAL,"498492999","descricao teste"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/,5, TipoContato.COMERCIAL,"598492999","descricao teste"));
    }

    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public void delete(Contato contato) {
        listaContatos.remove(contato);
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }
}
