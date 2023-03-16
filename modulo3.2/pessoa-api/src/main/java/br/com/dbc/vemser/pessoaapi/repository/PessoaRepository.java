package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.dto.PessoaRelacoesDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//public interface PessoaRepository extends JpaRepository<ENTIDADE,TIPODOMEUID> {
@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity,Integer> {

    @Query("select p.idPessoa, p.nome, p.email from Pessoa p where p.idPessoa = :id")
    List<PessoaEntity> findPessoa(Integer id);

    @Query(value = "select new br.com.dbc.vemser.pessoaapi.dto.PessoaRelacoesDTO(" +
            " p.idPessoa," +
            " p.nome," +
            " p.email," +
            " c.numero," +
            " e.cep," +
            " e.cidade, " +
            " e.estado, " +
            " e.pais," +
            " pt.nomePet," +
            " f.descricaoFilme," +
            " pf.descricao," +
            " pf.dtAssistido," +
            " f.notaFilme," +
            " pf.notaPessoa)" +
            " from Pessoa p" +
            " left join p.contatos c " +
            " left join p.enderecos e " +
            " left join p.pets pt " +
            " left join p.pessoaFilmeEntity pf" +
            " left join pf.filmeEntity f")
    List<PessoaRelacoesDTO> listaPessoaRelacoes();
}