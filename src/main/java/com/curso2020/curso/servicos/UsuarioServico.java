package com.curso2020.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso2020.curso.entidades.Usuario;
import com.curso2020.curso.repositorios.UsuarioRepositorio;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> findAll() {
        return usuarioRepositorio.findAll();
    }

    public Usuario findById(Long id) {
        Optional<Usuario> obj = usuarioRepositorio.findById(id);
        return obj.get();
    }

    public Usuario findByEmail(String email) {
        return usuarioRepositorio.findByEmail(email).orElse(null);
    }

    public Usuario insert(Usuario obj) {
        return usuarioRepositorio.save(obj);
    }

    public Usuario autenticar(String email, String senha) {
        Usuario usuario = findByEmail(email);
        if (usuario != null && passwordEncoder.matches(senha, usuario.getSenha())) {
            return usuario;
        }
        return null;
    }
}
