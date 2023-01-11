package com.attornatus.pessoas.repositories;

import com.attornatus.pessoas.entities.Endereco;
import com.attornatus.pessoas.entities.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("SELECT obj FROM Endereco obj WHERE "
            + "(:naoPrincipal = false OR obj.principal = false) ")
    Page<Endereco> find(boolean naoPrincipal, Pageable pageable);
}
