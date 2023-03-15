package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Endereco")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
    @SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "seq_endereco2", allocationSize = 1)
    @Column(name = "id_endereco")
    private Integer idEndereco;
    @Column(name = "tipo")
    private TipoEndereco tipo;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private Integer numero;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "cep")
    private String cep;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado")
    private String estado;
    @Column(name = "pais")
    private String pais;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private Set<PessoaEntity> pessoa;
}
