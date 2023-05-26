package com.programacionparaaprender.app.model.request;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EjemploRequestTest {
	@Test
    void testRequest1() {
		String name = "name";
        EjemploRequest request = new EjemploRequest();
        request.setName(name);
        assertEquals(request.getName(), name);
    }
	
	@Test
    void testRequest2() {
		String name = "name";
        EjemploRequest request = new EjemploRequest(name);
        assertEquals(request.getName(), name);
    }
}
