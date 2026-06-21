package com.gsm._8th.class4.backed.task._1._1.domain.dto;

import com.gsm._8th.class4.backed.task._1._1.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ArticleResponseDto {

    private Long idx;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ArticleResponseDto from(Article article) {
        return new ArticleResponseDto(
                article.getIdx(),
                article.getTitle(),
                article.getContent(),
                article.getCreatedAt(),
                article.getUpdatedAt()
        );
    }
}
