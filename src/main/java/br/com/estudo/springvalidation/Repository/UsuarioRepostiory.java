package br.com.estudo.springvalidation.Repository;


import br.com.estudo.springvalidation.entites.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepostiory extends JpaRepository<Usuario, Long> {
}
