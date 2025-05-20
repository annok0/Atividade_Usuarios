package com.atv.usuario.Service;

import com.atv.usuario.Entity.Usuario;
import com.atv.usuario.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UsuarioService {

    @Autowired
    private UsuarioRepository repositorio;

    public List<Usuario> listar() {
        return repositorio.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        return repositorio.save(usuario);
    }

    public void deletar(Long id) {
        repositorio.deleteById(id);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return repositorio.findById(id);
    }
}
