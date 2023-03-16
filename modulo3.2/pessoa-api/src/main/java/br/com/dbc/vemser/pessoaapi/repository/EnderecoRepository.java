package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity,Integer> {

    List<EnderecoEntity> findAllByPessoa(PessoaEntity pessoaEntity);

    @Query("select e from Endereco_Pessoa e where e.pais = :pais")
    List<EnderecoEntity> findByPais(String pais);

}