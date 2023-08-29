package com.fan.service;

import com.fan.dto.PromptRequestDto;
import com.fan.dto.PromptResponseDto;
import com.fan.dto.PromptResponseDto.PromptMainResponseDto;
import java.util.*;

import com.fan.dto.restDto.RestInputRequest;
import com.fan.dto.restDto.RestInputRequest.RestInputMainRequestDto;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class PromptService {
    private final WebClient webClient;

    public PromptService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://localhost").build();
    }
    public Mono<List<PromptMainResponseDto>> fetchPromptData(RestInputMainRequestDto requestDto) {
        return webClient.post()
                .uri("/data-endpoint")
                .bodyValue(requestDto)
                .retrieve()
                .bodyToFlux(PromptMainResponseDto.class)
                .collectList();
    }
}
