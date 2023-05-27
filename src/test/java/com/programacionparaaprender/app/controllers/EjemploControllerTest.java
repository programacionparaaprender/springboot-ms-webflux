package com.programacionparaaprender.app.controllers;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.programacionparaaprender.app.model.request.EjemploRequest;
import com.programacionparaaprender.app.model.response.EjemploResponse;
import com.programacionparaaprender.app.service.EjemploService;

@AutoConfigureWebTestClient(timeout = "20000")
@ExtendWith(MockitoExtension.class)
class EjemploControllerTest {
    
    @MockBean
    EjemploService ejemploService;
    
    @Autowired
    private WebTestClient webClient;

    @BeforeAll
    public static void setUp() {

    }

    @Order(1)
    @Test
    void indexGetTest() {
        String port="8080";
		String username="sa";
    	String cadena = "puerto: " + port + " username: " + username;
        EjemploResponse ejemploResp = new EjemploResponse();
        ejemploResp.setTexto(cadena);
        when(ejemploService.get()).thenReturn(ejemploResp);
        
        this.webClient.get()
            .uri("/ejemplo/v1/ejemplo")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk()
            .expectBody(EjemploResponse.class)
            .consumeWith(response -> {
                EjemploResponse reciboResponse = response.getResponseBody();
                if(reciboResponse!=null){
                    assertEquals(ejemploResp.getTexto(), reciboResponse.getTexto());
                }
            });
    }

    

    @Order(2)
    @Test
    void indexPostTest() {
        String port="8080";
        String cadena = port + " created!";
        EjemploResponse ejemploResp = new EjemploResponse();
        ejemploResp.setTexto(cadena);
        EjemploRequest request = new EjemploRequest(port);
        when(ejemploService.put(port)).thenReturn(ejemploResp);

        this.webClient.post()
            .uri("/ejemplo/v1/ejemplo")
            .accept(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(request))
            .exchange()
            .expectStatus().isEqualTo(HttpStatus.CREATED)
            .expectBody(EjemploResponse.class)
            .isEqualTo(ejemploResp);
    }

    @Order(3)
    @Test
    void indexGetDatosTest() {
        String datos;
        datos = "datos";
        EjemploResponse ejemploResp = new EjemploResponse();
        ejemploResp.setTexto(datos);
        when(ejemploService.get()).thenReturn(ejemploResp);
        
        this.webClient.get()
            .uri("/ejemplo/v1/ejemplo", datos)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk()
            .expectBody(EjemploResponse.class)
            .consumeWith(response -> {
                EjemploResponse reciboResponse = response.getResponseBody();
                if(reciboResponse!=null){
                    assertEquals(ejemploResp.getTexto(), reciboResponse.getTexto());
                }
            });
    }


}
