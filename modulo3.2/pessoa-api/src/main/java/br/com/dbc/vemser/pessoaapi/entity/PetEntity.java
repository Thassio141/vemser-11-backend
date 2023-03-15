package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Pet")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PET_SEQ")
    @SequenceGenerator(name = "PET_SEQ", sequenceName = "seq_pet", allocationSize = 1)
    @Column(name = "id_pet")
    private Integer id_pet;
    @Column(name = "id_pessoa")
    private Integer id_pessoa;
    @Column(name = "nome")
    private String nome;
    @Column(name = "tipo")
    private TipoPet tipoPet;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_pet",referencedColumnName = "id_pet")
    private PetEntity pet;
}
