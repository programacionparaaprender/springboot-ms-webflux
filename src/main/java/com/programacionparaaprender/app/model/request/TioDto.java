package com.programacionparaaprender.app.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TioDto {
    @NotBlank
    private String nombre;
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
    
}
