package com.attornatus.pessoas.dtos;

import com.attornatus.pessoas.entities.Endereco;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto implements Serializable {

    private Long id;
    private String cep;
    private String logradouro;
    private String cidade;
    private Integer numero;

    public EnderecoDto(Endereco entity) {
        id = entity.getId();
        cep = entity.getCep();
        logradouro = entity.getLogradouro();
        cidade = entity.getCidade();
        numero = entity.getNumero();
    }
}
