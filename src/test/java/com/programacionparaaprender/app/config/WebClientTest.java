package com.programacionparaaprender.app.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import com.programacionparaaprender.app.model.response.EjemploResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
class WebClientTest {    
    @Mock
    private WebClient webClientMock;

    @Mock
    private WebClient.ResponseSpec responseSpecMock;

    @SuppressWarnings("rawtypes")
    @Mock
    private WebClient.RequestHeadersSpec requestHeadSmock;

    @SuppressWarnings("rawtypes")
    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpecMock;

    @Test
    void getDatosTest() {
        String datos = "8080";
        EjemploResponse response = new EjemploResponse();
        response.setTexto(datos);
        Mono<EjemploResponse> metodoPrueba = Mono.just(response);
        HttpHeaders headers = new HttpHeaders();
        //headers.add("Ejemplo", "Ejemplo");
        String url = "http://localhost:9685/ejemplo/v1/ejemplo";
        when(responseSpecMock.bodyToMono(EjemploResponse.class)).thenReturn(metodoPrueba);
        when(webClientMock.get()).thenReturn(requestHeadersUriSpecMock);
        when(requestHeadersUriSpecMock.uri(url, datos)).thenReturn(requestHeadSmock);
        when(requestHeadSmock.accept(Mockito.any(MediaType.class))).thenReturn(requestHeadSmock);
        when(requestHeadSmock.headers(Mockito.notNull())).thenReturn(requestHeadSmock);
        when(requestHeadSmock.retrieve()).thenReturn(responseSpecMock);
        when(webClientMock.get().uri(url, datos).headers(httpHeaders -> httpHeaders.addAll(headers))
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(EjemploResponse.class))
                        .thenReturn(metodoPrueba);
        Mono<EjemploResponse> resultado = webClientMock.get().uri(url, datos)
                //.headers(httpHeaders -> httpHeaders.addAll(headers))
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(EjemploResponse.class);
        assertEquals(metodoPrueba, resultado);
    }


    @Test
    void getTest() {
        String port="8080";
		String username="sa";
    	String cadena = "puerto: " + port + " username: " + username;
        EjemploResponse ejemploResp = new EjemploResponse();
        ejemploResp.setTexto(cadena);
        Mono<EjemploResponse> metodoResponse = Mono.just(ejemploResp);
        String url = "http://localhost:9685/ejemplo/v1/ejemplo";
        HttpHeaders headers = new HttpHeaders();
        //headers.add("Ejemplo", "Ejemplo");
        when(responseSpecMock.bodyToMono(EjemploResponse.class)).thenReturn(metodoResponse);
        when(webClientMock.get()).thenReturn(requestHeadersUriSpecMock);
        when(requestHeadersUriSpecMock.uri(url)).thenReturn(requestHeadSmock);
        when(requestHeadSmock.accept(Mockito.any(MediaType.class))).thenReturn(requestHeadSmock);
        when(requestHeadSmock.headers(Mockito.notNull())).thenReturn(requestHeadSmock);
        when(requestHeadSmock.retrieve()).thenReturn(responseSpecMock);
        when(webClientMock.get().uri(url)
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(EjemploResponse.class))
                        .thenReturn(metodoResponse);
        Mono<EjemploResponse> resultado = webClientMock.get().uri(url).headers(httpHeaders -> httpHeaders.addAll(headers))
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(EjemploResponse.class);
        assertEquals(metodoResponse, resultado);
    }
}
