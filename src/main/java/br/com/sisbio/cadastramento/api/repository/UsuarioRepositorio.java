package br.com.sisbio.cadastramento.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sisbio.cadastramento.api.Usuario;
import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

}
