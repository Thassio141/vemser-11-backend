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
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), COUNTER.incrementAndGet(), TipoContato.COMERCIAL, "79 998482999", "descricao teste"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), COUNTER.incrementAndGet(), TipoContato.COMERCIAL, "79 994324312", "descricao teste"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), COUNTER.incrementAndGet(), TipoContato.RESIDENCIAL, "79 982131990", "descricao teste"));
    }

    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public Contato update(Integer id,Contato contatoAtualizar) {
        contatoAtualizar.setTipoContato(contatoAtualizar.getTipoContato());
        contatoAtualizar.setNumero(contatoAtualizar.getNumero());
        contatoAtualizar.setDescricao(contatoAtualizar.getDescricao());
        return contatoAtualizar;
    }

    public void delete(Contato contato) {
        listaContatos.remove(contato);
    }

    public List<Contato> listByNumber(String numero) {
        return listaContatos.stream()
                .filter(contato -> contato.getNumero().contains(numero))
                .collect(Collectors.toList());
    }
}
