package com.fan.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class promptRequestDto {
    @Getter
    @Builder
    public class promptMainRequestDto(){
        @NonNull
        private String keyWord;
        private Integer age;
        private String animal;
        private String isInputRequest(){
            return keyWord + "에 대해서" + age + "세 어린이에게 설명할 건데 동화 만화 같은 느낌으로 해줘 " +
                    "설명하는 캐릭터는" + animal + "을 사용해줬으면 좋겠어";
        }
    }
}
