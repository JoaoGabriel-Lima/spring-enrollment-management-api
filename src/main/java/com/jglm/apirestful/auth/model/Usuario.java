package com.jglm.apirestful.auth.model;

import com.jglm.apirestful.auth.util.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O 'Nome' deve ser informado.")
    private String nome;

    @NotEmpty(message = "O 'Email' deve ser informado.")
    @Email(message = "Email inválido.")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "A 'Senha' deve ser informada.")
    @Size(min = 6, message = "A 'Senha' deve ter no mínimo 6 caracteres.")
    private String senha;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    public Usuario(String nome, String email, String senha, Role role) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

}
