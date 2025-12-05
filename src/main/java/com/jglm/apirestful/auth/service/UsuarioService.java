package com.jglm.apirestful.auth.service;

import com.jglm.apirestful.auth.model.Usuario;
import com.jglm.apirestful.auth.repository.UsuarioRepository;
import com.jglm.apirestful.auth.util.InfoUsuario;
import com.jglm.apirestful.auth.util.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    // Cadastro público - sempre USER
    public InfoUsuario cadastrarUsuario(Usuario usuario) {
        return cadastrarUsuarioInterno(usuario, Role.USER);
    }

    // Cadastro por ADMIN - mantém o role enviado
    public InfoUsuario cadastrarUsuarioComRole(Usuario usuario) {
        Role role = usuario.getRole() != null ? usuario.getRole() : Role.USER;
        return cadastrarUsuarioInterno(usuario, role);
    }

    private InfoUsuario cadastrarUsuarioInterno(Usuario usuario, Role role) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            return new InfoUsuario(false, true, "Email já cadastrado!");
        }

        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuario.setRole(role);
        usuarioRepository.save(usuario);
        return new InfoUsuario(true, false, "Usuário cadastrado com sucesso!");
    }

    public List<Usuario> recuperarUsuarios() {
        return usuarioRepository.findAll();
    }
}
