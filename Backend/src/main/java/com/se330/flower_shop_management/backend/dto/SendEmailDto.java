package com.se330.flower_shop_management.backend.dto;

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
public class SendEmailDto {
    @NotNull
    @NotBlank(message = "Email must not be empty.")
    @Email
    private String email;
    @NotNull
    @NotBlank(message = "Pincode must not be empty.")
    @Size(min = 6, message = "Pincode must be 6 digits string.")
    private String pincode;
}
