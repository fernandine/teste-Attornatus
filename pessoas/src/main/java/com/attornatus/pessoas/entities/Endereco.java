package com.attornatus.pessoas.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Data
@Table(name="tb_endereco")
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String cidade;
    private Integer numero;
    private Boolean principal;
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Endereco endereco;
}

