package com.attornatus.pessoas.dtos;

import com.attornatus.pessoas.entities.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class PessoaDto implements Serializable {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;

    public List<EnderecoDto> enderecos = new ArrayList<>();

    public PessoaDto() {
    }

    public PessoaDto(Pessoa entity) {
        id = entity.getId();
        nome = entity.getNome();
        dataNascimento = entity.getDataNascimento();
        entity.getEnderecos().forEach(p -> this.enderecos.add(new EnderecoDto(p)));
    }
}
