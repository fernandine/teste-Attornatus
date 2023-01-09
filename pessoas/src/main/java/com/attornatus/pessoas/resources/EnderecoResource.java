package com.attornatus.pessoas.resources;

import com.attornatus.pessoas.dtos.EnderecoDto;
import com.attornatus.pessoas.services.EnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Api(tags = "Endereço Resource", value = "EnderecoResource")
@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

    @Autowired
    private EnderecoService service;

    @ApiOperation(value = "Obtendo a lista de todos enderecos cadastrados.")
    @GetMapping
    public ResponseEntity<List<EnderecoDto>> findAll() {
        List<EnderecoDto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @ApiOperation(value = "Cadastrando no banco de dados um endereco.")
    @PostMapping
    public ResponseEntity<EnderecoDto> insert(@Valid @RequestBody EnderecoDto dto) {
        EnderecoDto newDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @ApiOperation(value = "Atualizando um endereco pelo seu ID")
    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDto> update(@PathVariable Long id, @RequestBody EnderecoDto dto) {
        EnderecoDto newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @ApiOperation(value = "Deleta um endereco pelo seu ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
