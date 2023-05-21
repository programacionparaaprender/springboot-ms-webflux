package com.programacionparaaprender.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.programacionparaaprender.app.model.request.EjemploRequest;
import com.programacionparaaprender.app.model.response.EjemploResponse;
import com.programacionparaaprender.app.service.EjemploService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ejemplo/v1/ejemplo")
public class EjemploController {
	@Autowired
	private EjemploService ejemploService;
	
    @GetMapping
    public Mono<EjemploResponse> indexGet() {
    	String port="8080";
		String username="sa";
    	return Mono.justOrEmpty(this.ejemploService.get("puerto: " + port + " username: " + username));
    }

    @GetMapping("{datos}")
    public Mono<EjemploResponse> indexGetData(String datos) {
    	return Mono.justOrEmpty(this.ejemploService.get(datos));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<EjemploResponse> indexPost(@RequestBody EjemploRequest request) {
        return Mono.justOrEmpty(this.ejemploService.put(request.getName()));
    }
}
