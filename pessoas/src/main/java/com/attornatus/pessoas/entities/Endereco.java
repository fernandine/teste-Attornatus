package com.attornatus.pessoas.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="tb_endereco")
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String cidade;
    private Integer numero;
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
}
