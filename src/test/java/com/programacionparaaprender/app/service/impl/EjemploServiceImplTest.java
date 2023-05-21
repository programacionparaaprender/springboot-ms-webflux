package com.programacionparaaprender.app.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.programacionparaaprender.app.model.response.EjemploResponse;
import com.programacionparaaprender.app.service.impl.EjemploServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
class EjemploServiceImplTest {

    @Mock
    private WebClient webClientMock;

    @SuppressWarnings("rawtypes")
    @Mock
    private WebClient.RequestHeadersSpec requestheadSmock;

    @SuppressWarnings("rawtypes")
    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpecMock;

    @Mock
    private WebClient.ResponseSpec responseSpecMock;

    @SuppressWarnings("rawtypes")
    @Mock
    private WebClient.RequestBodyUriSpec requestBodyUriSpec;
    
    @Mock
    private WebClient.RequestBodySpec requestBodySpec;
    
    @InjectMocks
    private EjemploServiceImpl ejemploServiceImpl;

    @Test
    void testGet() {
        EjemploResponse ejemplo = new EjemploResponse();
		ejemplo.setTexto("GET!");
        //when(ejemploServiceImpl.get()).thenReturn(ejemplo);
        //String url = "http://localhost:9685/ejemplo/v1/ejemplo";
        //when(webClientMock.get()).thenReturn(requestHeadersUriSpecMock);
        //when(requestHeadersUriSpecMock.uri(url)).thenReturn(requestheadSmock);
        //when(requestheadSmock.accept(Mockito.any(MediaType.class))).thenReturn(requestheadSmock);
        //when(requestheadSmock.headers(Mockito.notNull())).thenReturn(requestheadSmock);
        //when(requestheadSmock.retrieve()).thenReturn(responseSpecMock);
        EjemploResponse resultado = ejemploServiceImpl.get();
        assertEquals(ejemplo, resultado);
    }

    @Test
    void testGetDatos() {
        EjemploResponse ejemplo = new EjemploResponse();
		ejemplo.setTexto("ejemplo");
        //when(ejemploServiceImpl.get()).thenReturn(ejemplo);
        //String url = "http://localhost:9685/ejemplo/v1/ejemplo";
        //when(webClientMock.get()).thenReturn(requestHeadersUriSpecMock);
        //when(requestHeadersUriSpecMock.uri(url)).thenReturn(requestheadSmock);
        //when(requestheadSmock.accept(Mockito.any(MediaType.class))).thenReturn(requestheadSmock);
        //when(requestheadSmock.headers(Mockito.notNull())).thenReturn(requestheadSmock);
        //when(requestheadSmock.retrieve()).thenReturn(responseSpecMock);
        EjemploResponse resultado = ejemploServiceImpl.get("ejemplo");
        assertEquals(ejemplo, resultado);
    }

    @Test
    void testPut() {
        String name = "ejemplo created!";
        EjemploResponse ejemplo = new EjemploResponse();
		ejemplo.setTexto(name);
        //when(ejemploServiceImpl.get()).thenReturn(ejemplo);
        //String url = "http://localhost:9685/ejemplo/v1/ejemplo";
        //when(webClientMock.get()).thenReturn(requestHeadersUriSpecMock);
        //when(requestHeadersUriSpecMock.uri(url)).thenReturn(requestheadSmock);
        //when(requestheadSmock.accept(Mockito.any(MediaType.class))).thenReturn(requestheadSmock);
        //when(requestheadSmock.headers(Mockito.notNull())).thenReturn(requestheadSmock);
        //when(requestheadSmock.retrieve()).thenReturn(responseSpecMock);
        EjemploResponse resultado = ejemploServiceImpl.put("ejemplo");
        assertEquals(ejemplo, resultado);
    }

}

