package com.programacionparaaprender.app.model.request;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EjemploRequest {
	public static final String NOT_EMPTY = "no puede quedar sin valor";

    @NotEmpty(message = NOT_EMPTY)
    private String name;
}
