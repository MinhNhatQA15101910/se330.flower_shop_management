package com.se330.flower_shop_management.backend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginGoogleRequestDto {
    @NotNull
    @NotBlank(message = "Username is required.")
    private String username;

    @Email(message = "Email should be valid.")
    @NotNull
    @NotBlank(message = "Email is required.")
    private String email;

    @NotNull
    @NotBlank(message = "Password is required.")
    @Size(min = 6, message = "Password must be at least 6 characters long.")
    private String password;

    private String image_url;
}
