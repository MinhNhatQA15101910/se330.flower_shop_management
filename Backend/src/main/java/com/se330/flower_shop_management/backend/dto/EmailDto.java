package com.se330.flower_shop_management.backend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto {
    @Valid

    @Email
    @NotNull
    @NotBlank
    private String email;
}
