package com.atv.usuario.Controller;

import com.atv.usuario.Entity.Usuario;
import com.atv.usuario.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario) {
        return service.salvar(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario atualizado) {
        return service.buscarPorId(id)
                .map(aviso -> {
                    aviso.setNome(atualizado.getNome());
                    aviso.setSobrenome(atualizado.getSobrenome());
                    aviso.setCPF(atualizado.getCPF());
                    aviso.setEmail(atualizado.getEmail());
                    aviso.setData_nascimento(atualizado.getData_nascimento());
                    return ResponseEntity.ok(service.salvar(aviso));
                }).orElse(ResponseEntity.notFound().build());
    }
}
