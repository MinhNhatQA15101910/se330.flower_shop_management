package com.se330.flower_shop_management.backend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @Valid

    @NotNull(message = "Username is mandatory.")
    @NotBlank(message = "Username is mandatory.")
    @Size(min = 6, message = "Password must be at least 6 characters long.")
    private String username;
    @Email
    @NotNull(message = "Email is mandatory.")
    @NotBlank(message = "Email is mandatory.")
    private String email;
    @NotNull(message = "Password is mandatory.")
    @NotBlank(message = "Password is mandatory.")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    private String password;
}