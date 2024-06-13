package com.se330.flower_shop_management.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDto {
    @NotNull
    @NotBlank
    @Size(min = 6, message = "Username must be at least 6 characters long.")
    private String username;

    @NotNull
    @NotBlank(message = "Email must not be empty.")
    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    private String password;
}
