package com.fan.dto;

import lombok.Getter;

public class PromptResponseDto {
    @Getter
    public class PromptMainResponseDto{
        private String message;
        private String imageUrl;
    }
}
