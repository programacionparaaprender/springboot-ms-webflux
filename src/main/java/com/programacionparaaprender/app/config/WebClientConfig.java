package com.programacionparaaprender.app.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig{

	@Bean("webClientEjemplo")
	public WebClient webClient() {
		return WebClient.builder()
				.clientConnector(conector())
				.exchangeStrategies(estrategia())
				.build();
	}

private static ClientHttpConnector conector() {
		return new ReactorClientHttpConnector(httpClient());
	}

	private static HttpClient httpClient() {
		return HttpClient.create()
				.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
				.doOnConnected(conn -> conn
						.addHandler(new ReadTimeoutHandler(14, TimeUnit.SECONDS))
						.addHandler(new WriteTimeoutHandler(14, TimeUnit.SECONDS)));
	} 

	private static ExchangeStrategies estrategia() {
		return ExchangeStrategies.builder()
				.codecs(configurer -> configurer
						.defaultCodecs()
						.maxInMemorySize(4 * 1024 * 1024)
				)
				.build();
	}
}

