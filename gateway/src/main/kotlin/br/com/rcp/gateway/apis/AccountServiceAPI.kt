package br.com.rcp.gateway.apis

import br.com.rcp.gateway.dto.AuthenticationDTO
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class AccountServiceAPI(private val client: WebClient) {
	fun find(username: String) : Mono<AuthenticationDTO?> {
		return client
			.get()
			.uri("/authentication/find-by-username/$username")
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
			.flatMap { it.bodyToMono(AuthenticationDTO::class.java) }
	}
}