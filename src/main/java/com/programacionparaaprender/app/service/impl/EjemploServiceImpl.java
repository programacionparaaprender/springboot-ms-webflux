package com.programacionparaaprender.app.service.impl;

import org.springframework.stereotype.Service;

import com.programacionparaaprender.app.model.response.EjemploResponse;
import com.programacionparaaprender.app.service.EjemploService;


@Service
public class EjemploServiceImpl implements EjemploService {

	@Override
	public EjemploResponse get(String datos) {
		EjemploResponse ejemplo = new EjemploResponse();
		ejemplo.setTexto(datos);
		return ejemplo;
	}
	
	@Override
	public EjemploResponse get() {
		EjemploResponse ejemplo = new EjemploResponse();
		ejemplo.setTexto("GET!");
		return ejemplo;
	}
	
	@Override
	public EjemploResponse put(String name) {
		EjemploResponse ejemplo = new EjemploResponse();
		ejemplo.setTexto(name + " created!");
		return ejemplo;
	}

}
