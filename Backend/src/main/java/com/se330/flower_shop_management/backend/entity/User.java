package com.se330.flower_shop_management.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Valid

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    @NotNull(message = "Username is mandatory.")
    @NotBlank(message = "Username is mandatory.")
    @Size(min = 6, message = "Username must be at least 6 characters long.")
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotNull(message = "Email is mandatory.")
    @NotBlank(message = "Email is mandatory.")
    private String email;

    @Column(name = "password", nullable = false)
    @NotNull(message = "Password is mandatory.")
    @NotBlank(message = "Password is mandatory.")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    private String password;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    public User(String username, String email, String hashedPassword) {
        this.username = username;
        this.email = email;
        this.password = hashedPassword;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}