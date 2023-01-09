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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional(readOnly = true)
    public List<PessoaDto> findAll() {
        List<Pessoa> list = repository.findAll();
        return list.stream().map(x -> new PessoaDto(x)).collect(Collectors.toList());
    }

    //BUSCA PAGINADA
    @Transactional(readOnly = true)
    public Page<PessoaDto> findAllPaged(Pageable pageable) {
        Page<Pessoa> list = repository.findAll(pageable);
        return list.map(x -> new PessoaDto(x));
    }

    @Transactional(readOnly = true)
    public PessoaDto findById(Long id) {
        Optional<Pessoa> obj = repository.findById(id);
        Pessoa entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new PessoaDto(entity);
    }

    @Transactional
    public PessoaDto insert(PessoaDto dto) {
        Pessoa entity = new Pessoa();
        entity.setNome(dto.getNome());
        entity.setDataNasc(dto.getDataNasc());

        for (EnderecoDto p : dto.getEnderecos()) {
            Endereco endereco = enderecoRepository.getReferenceById(p.getId());
            entity.getEnderecos().add(endereco);

        }

        entity = repository.save(entity);
        return new PessoaDto(entity);
    }

    @Transactional
    public PessoaDto update(Long id, PessoaDto dto) {
        try {
            Pessoa entity = repository.getReferenceById(id);
            entity.setNome(dto.getNome());
            entity.setDataNasc(dto.getDataNasc());
            entity = repository.save(entity);
            return new PessoaDto(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }
}

