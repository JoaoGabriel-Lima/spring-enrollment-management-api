package com.jglm.apirestful.auth.controller;

import com.jglm.apirestful.auth.model.Usuario;
import com.jglm.apirestful.auth.service.UsuarioService;
import com.jglm.apirestful.auth.util.InfoUsuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("usuarios") // htttp://localhost:8080/usuarios
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> recuperaUsuarios() {
        return usuarioService.recuperarUsuarios();
    }

    // Cadastro público - sempre cria USER
    @PostMapping
    public InfoUsuario cadastrarUsuario(@RequestBody @Valid Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }

    // Cadastro por ADMIN - pode definir o role (USER ou ADMIN)
    @PostMapping("/admin")
    public InfoUsuario cadastrarUsuarioAdmin(@RequestBody @Valid Usuario usuario) {
        return usuarioService.cadastrarUsuarioComRole(usuario);
    }
}
