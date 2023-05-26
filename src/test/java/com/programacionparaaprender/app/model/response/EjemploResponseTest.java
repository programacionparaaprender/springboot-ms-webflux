package com.programacionparaaprender.app.model.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EjemploResponseTest {
	@Test
    void testResponse() {
        String ejemplo = "ejemplo";
		EjemploResponse response = new EjemploResponse();
        response.setTexto(ejemplo);
        
        assertEquals(response.getTexto(), ejemplo);
    }
}
