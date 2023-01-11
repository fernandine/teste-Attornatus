package com.attornatus.pessoas.dtos;

import com.attornatus.pessoas.entities.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnderecoDto implements Serializable {

    private Long id;
    private String cep;
    private String logradouro;
    private String cidade;
    private Integer numero;
    private Boolean principal;

    public EnderecoDto(Endereco entity) {
        id = entity.getId();
        cep = entity.getCep();
        logradouro = entity.getLogradouro();
        cidade = entity.getCidade();
        numero = entity.getNumero();
        principal = entity.getPrincipal();
    }
}
