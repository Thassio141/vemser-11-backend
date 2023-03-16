package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Pessoa")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    //    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
    @JsonIgnore
    private Set<ContatoEntity> contatos;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="PESSOA_X_PESSOA_ENDERECO",
    joinColumns = @JoinColumn(name = "id_pessoa"),
    inverseJoinColumns = @JoinColumn(name= "id_endereco"))
    @JsonIgnore
    private Set<EnderecoEntity> enderecos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
    @JsonIgnore
    private Set<PetEntity> pets;

    @OneToMany(fetch= FetchType.LAZY, mappedBy = "pessoaEntity" )
    @JsonIgnore
    private Set<PessoaFilmeEntity> pessoaFilmeEntity;
}