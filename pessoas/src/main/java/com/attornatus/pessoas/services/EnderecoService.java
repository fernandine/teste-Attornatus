package com.attornatus.pessoas.services;

import com.attornatus.pessoas.dtos.EnderecoDto;
import com.attornatus.pessoas.dtos.PessoaDto;
import com.attornatus.pessoas.entities.Endereco;
import com.attornatus.pessoas.entities.Pessoa;
import com.attornatus.pessoas.repositories.EnderecoRepository;
import com.attornatus.pessoas.repositories.PessoaRepository;
import com.attornatus.pessoas.services.exceptions.DatabaseException;
import com.attornatus.pessoas.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional(readOnly = true)
    public List<EnderecoDto> findAll() {
        List<Endereco> list = enderecoRepository.findAll();
        return list.stream().map(x -> new EnderecoDto(x)).collect(Collectors.toList());
    }

    //BUSCA PAGINADA
    @Transactional(readOnly = true)
    public Page<EnderecoDto> findAllPaged(Pageable pageable) {
        Page<Endereco> list = enderecoRepository.findAll(pageable);
        return list.map(x -> new EnderecoDto(x));
    }

    @Transactional
    public EnderecoDto insert(EnderecoDto dto) {
        Endereco entity = new Endereco();

        entity.setCep(dto.getCep());
        entity.setLogradouro(dto.getLogradouro());
        entity.setCidade(dto.getCidade());
        entity.setNumero(dto.getNumero());


        entity = enderecoRepository.save(entity);
        return new EnderecoDto(entity);
    }

    @Transactional
    public EnderecoDto update(Long id, EnderecoDto dto) {
        try {
            Endereco entity = enderecoRepository.getReferenceById(id);
            entity.setCep(dto.getCep());
            entity.setLogradouro(dto.getLogradouro());
            entity.setCidade(dto.getCidade());
            entity.setNumero(dto.getNumero());

            entity = enderecoRepository.save(entity);
            return new EnderecoDto(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            enderecoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }
}