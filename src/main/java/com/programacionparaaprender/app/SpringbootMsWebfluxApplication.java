package com.programacionparaaprender.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class SpringbootMsWebfluxApplication {

	public static void main(String[] args) {
		
		try {
			SpringApplication.run(SpringbootMsWebfluxApplication.class, args);	
    	}catch(Exception ex) {
    		//log.error("Error: {}", ex.getMessage());
    	}
	}

}
