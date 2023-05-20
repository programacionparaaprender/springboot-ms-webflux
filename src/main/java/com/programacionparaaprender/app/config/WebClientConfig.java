package com.programacionparaaprender.app.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig{

	@Bean("webClientEjemplo")
	public WebClient webClient() {
		return WebClient.builder()
				//.clientConnector(connector())
				.exchangeStrategies(strategie())
				.filter(errorHandlingFilter())
				.build();
	}


	private static ExchangeFilterFunction errorHandlingFilter() {
		return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
			if (clientResponse.statusCode().isError()) {
				return clientResponse.createException().flatMap(Mono::error);
			} else {
				return Mono.just(clientResponse);
			}
		});
	}

	/* private static ClientHttpConnector connector() {
		return new ReactorClientHttpConnector(httpClient());
	}

	private static HttpClient httpClient() {
		return HttpClient.create()
				.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
				.doOnConnected(conn -> conn
						.addHandler(new ReadTimeoutHandler(14, TimeUnit.SECONDS))
						.addHandler(new WriteTimeoutHandler(14, TimeUnit.SECONDS)));
	} */

	private static ExchangeStrategies strategie() {
		return ExchangeStrategies.builder()
				.codecs(configurer -> configurer
						.defaultCodecs()
						.maxInMemorySize(4 * 1024 * 1024)
				)
				.build();
	}
}

