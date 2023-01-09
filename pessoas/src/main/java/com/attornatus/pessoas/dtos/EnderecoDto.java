package com.attornatus.pessoas.dtos;

import com.attornatus.pessoas.entities.Endereco;
import java.io.Serializable;

public class EnderecoDto implements Serializable {

    private Long id;
    private String cep;
    private String logradouro;
    private String cidade;
    private Integer numero;

    public EnderecoDto() {
    }

    public EnderecoDto(Long id, String cep, String logradouro, String cidade, Integer numero) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.numero = numero;
    }

    public EnderecoDto(Endereco entity) {
        id = entity.getId();
        cep = entity.getCep();
        logradouro = entity.getLogradouro();
        cidade = entity.getCidade();
        numero = entity.getNumero();
    }

    public Long getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public Integer getNumero() {
        return numero;
    }
}
