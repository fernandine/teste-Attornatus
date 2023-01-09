package com.attornatus.pessoas.resources;

import com.attornatus.pessoas.dtos.PessoaDto;
import com.attornatus.pessoas.services.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Api(tags = "Pessoa Resource", value = "PessoaResource")
@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService service;

    @ApiOperation(value = "Obtendo a lista de todos as pessoas e seus respectivos endereços.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista criada com sucesso"),
            @ApiResponse(code = 400, message = "Houve um erro!")
    })
    @GetMapping
    public ResponseEntity<List<PessoaDto>> findAll() {
        List<PessoaDto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @ApiOperation(value = "Obtendo as informações do cliente pelo seu ID")
    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDto> findById(@PathVariable Long id) {
        PessoaDto dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @ApiOperation(value = "Cadastrando no banco de dados um cliente.")
    @PostMapping
    public ResponseEntity<PessoaDto> insert(@Valid @RequestBody PessoaDto dto) {
        PessoaDto newDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @ApiOperation(value = "Atualizando um cliente pelo seu ID")
    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaDto> update(@PathVariable Long id, @RequestBody PessoaDto dto) {
        PessoaDto newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @ApiOperation(value = "Deleta um cliente pelo seu ID")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
