package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
@Repository
public class EnderecoRepository {

    private static List<Endereco> listaEndereco = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(),1,TipoEndereco.COMERCIAL,"Rua A",123,"Comercial","49000-101","Cidade A", "Estado A", "Pais A"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(),2,TipoEndereco.COMERCIAL,"Rua B",124,"Comercial","49000-102","Cidade B", "Estado B", "Pais B"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(),3,TipoEndereco.RESIDENCIAL,"Rua C",125,"Casa","49000-103","Cidade C", "Estado C", "Pais C"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(),4,TipoEndereco.RESIDENCIAL,"Rua D",126,"Casa","49000-104","Cidade D", "Estado D", "Pais D"));
        listaEndereco.add(new Endereco(COUNTER.incrementAndGet(),5,TipoEndereco.RESIDENCIAL,"Rua E",127,"Casa","49000-105","Cidade E", "Estado E", "Pais E"));
    }
    public Endereco create(Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEndereco.add(endereco);
        return endereco;
    }

    public List<Endereco> list() {
        return listaEndereco;
    }

    public void delete(Endereco endereco) {
        listaEndereco.remove(endereco);
    }

    public List<Endereco> listByIdEndereco(Integer idEndereco) {
        return listaEndereco.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .collect(Collectors.toList());
    }
}
