package com.attornatus.pessoas.dtos;

import com.attornatus.pessoas.entities.Pessoa;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}
