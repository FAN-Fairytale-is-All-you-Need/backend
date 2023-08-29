package com.fan.dto;

import com.fan.dto.restDto.RestInputRequest;
import com.fan.dto.restDto.RestInputRequest.RestInputMainRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
public class PromptRequestDto {

    @Getter
    @Builder
    public class PromptMainRequestDto{
        @NotBlank(message ="키워드는 필수입니다.")
        private String keyWord;

        @Max(value = 13,message ="나이는 필수입니다.")
        private Integer age;

        @Pattern(regexp = "^(rabbit|bear|puppy)$", message = "잘못된 동물을 선택하였습니다.")
        private String animal;
        public RestInputMainRequestDto toCommand() {
            return RestInputMainRequestDto.builder()
                    .keyWord(keyWord)
                    .age(age)
                    .animal(animal)
                    .build();
        }
    }
}
