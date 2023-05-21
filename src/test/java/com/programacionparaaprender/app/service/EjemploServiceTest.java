package com.programacionparaaprender.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.programacionparaaprender.app.model.response.EjemploResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EjemploServiceTest {

    @Mock
    private EjemploService ejemploService;

    @Test
    void testGetsDatos() {
        EjemploResponse response = new EjemploResponse();
        response.setTexto("ejemplo");
        when(ejemploService.get("ejemplo")).thenReturn(response);
        EjemploResponse resultado = ejemploService.get("ejemplo");
        assertEquals(response, resultado);
    }

    @Test
    void testGets() {
        EjemploResponse response = new EjemploResponse();
        response.setTexto("ejemplo");
        when(ejemploService.get()).thenReturn(response);
        EjemploResponse resultado = ejemploService.get();
        assertEquals(response, resultado);
    }

    @Test
    void testPut() {
        EjemploResponse response = new EjemploResponse();
        response.setTexto("ejemplo");
        when(ejemploService.put("ejemplo")).thenReturn(response);
        EjemploResponse resultado = ejemploService.put("ejemplo");
        assertEquals(response, resultado);
    }

}