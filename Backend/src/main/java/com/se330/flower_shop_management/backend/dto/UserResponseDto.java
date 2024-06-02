package com.se330.flower_shop_management.backend.dto;

import com.google.gson.annotations.SerializedName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private String token;
    private Long id;
    private String username;
    private String email;
    private String password;
    @SerializedName(value = "image_url")
    private String imageUrl;
    private String role;
}