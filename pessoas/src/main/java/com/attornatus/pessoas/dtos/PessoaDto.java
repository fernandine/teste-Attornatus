package com.attornatus.pessoas.dtos;

import com.attornatus.pessoas.entities.Pessoa;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PessoaDto implements Serializable {

    private Long id;
    private String nome;
    private LocalDate dataNasc;
    public List<EnderecoDto> enderecos = new ArrayList<>();

    public PessoaDto(Pessoa entity) {
        id = entity.getId();
        nome = entity.getNome();
        dataNasc = entity.getDataNasc();
        entity.getEnderecos().forEach(p -> this.enderecos.add(new EnderecoDto(p)));
    }

    public PessoaDto(Long id, String nome, LocalDate dataNasc) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public List<EnderecoDto> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDto> enderecos) {
        this.enderecos = enderecos;
    }
}
