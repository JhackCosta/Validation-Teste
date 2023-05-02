package br.com.estudo.springvalidation.repositories;


import br.com.estudo.springvalidation.entites.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepostiory extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCpf(String cpf);
}
