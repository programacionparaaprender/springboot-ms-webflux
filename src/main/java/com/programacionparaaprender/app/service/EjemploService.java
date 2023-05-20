package com.programacionparaaprender.app.service;

import com.programacionparaaprender.app.model.response.EjemploResponse;

public interface EjemploService {
	EjemploResponse metodoPrueba(String port);
	EjemploResponse get(String datos);
	EjemploResponse get();
	EjemploResponse put(String name);
}
