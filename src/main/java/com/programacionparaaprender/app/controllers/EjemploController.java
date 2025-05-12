package com.programacionparaaprender.app.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

@Api(value = "EjemploService", description = "Microservicio de ejemplo")
@RestController
@RequestMapping("/ejemplo/v1/ejemplo")
@CrossOrigin
public class EjemploController {
	@Autowired
	private EjemploService ejemploService;

    
	
    @ApiOperation(value = "Obtener ejemplos del sistema ", notes = "Obtener ejemplos del sistema")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "indexGet") })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Mono<EjemploResponse> indexGet() {
    	String port="8080";
		String username="sa";
    	return Mono.justOrEmpty(this.ejemploService.get("puerto: " + port + " username: " + username));
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "indexGetData", required = true, value = "(Requerido) id del ejemplo.", dataType = "String")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Mono<EjemploResponse> indexGetData(@PathVariable("id") String id) {
    	return Mono.justOrEmpty(this.ejemploService.get(id));
    }

    @ApiOperation(value = "Crear nuevo ejemplo", notes = "Crear nuevo ejemplo del sistema")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<EjemploResponse> indexPost(@RequestBody EjemploRequest request) {
        return Mono.justOrEmpty(this.ejemploService.put(request.getName()));
    }
}
