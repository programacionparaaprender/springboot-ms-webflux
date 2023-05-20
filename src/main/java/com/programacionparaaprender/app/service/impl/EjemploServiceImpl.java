package com.programacionparaaprender.app.service.impl;

import org.springframework.stereotype.Service;

import com.programacionparaaprender.app.model.response.EjemploResponse;
import com.programacionparaaprender.app.service.EjemploService;


@Service
public class EjemploServiceImpl implements EjemploService {
	@Override
	public EjemploResponse metodoPrueba(String port) {
		EjemploResponse ejemplo = new EjemploResponse(port);
		return ejemplo;
	}
	
	@Override
	public EjemploResponse get(String datos) {
		return new EjemploResponse(datos);
	}
	
	@Override
	public EjemploResponse get() {
		return new EjemploResponse("GET!");
	}
	
	@Override
	public EjemploResponse put(String name) {
		return new EjemploResponse(name + " created!");
	}

}
