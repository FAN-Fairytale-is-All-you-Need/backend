package com.fan.controller;

import com.fan.dto.PromptRequestDto;
import com.fan.dto.PromptRequestDto.PromptMainRequestDto;
import com.fan.dto.PromptResponseDto;
import com.fan.dto.PromptResponseDto.PromptMainResponseDto;
import com.fan.service.PromptService;
import lombok.RequiredArgsConstructor;
import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RequestMapping("/prompt")
@RequiredArgsConstructor
public class PromptController {

    private final PromptService promptService;

    /**
     * 프롬포트 정보(키워드, 나이, 동물)를 요청받아 AI 서버에 요청하고 리턴해주는 API
     */
    @PostMapping("/")
    public Mono<List<PromptMainResponseDto>> requestPromptStory(
            @RequestBody @Valid PromptMainRequestDto request
    ){
        return promptService.fetchPromptData(request.toCommand());
    }
}
