package com.gsm._8th.class4.backed.task._1._1.domain.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ArticleUpdateRequestDto {
    private String title;

    private String content;
}
