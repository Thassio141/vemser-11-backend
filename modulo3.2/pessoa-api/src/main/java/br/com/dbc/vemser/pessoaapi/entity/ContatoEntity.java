package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity(name = "Contato")
public class ContatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name="CONTATO_SEQ", sequenceName = "seq_contato2", allocationSize=1)
    @Column(name = "id_contato")
    private Integer idContato;
    @Column(name = "id_pessoa")
    private Integer idPessoa;
    @Column(name = "tipo_contato")
    private TipoContato tipoContato;
    @Column(name = "numero")
    private String numero;
    @Column(name = "descricao")
    private String descricao;
}
