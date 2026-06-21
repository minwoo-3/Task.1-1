package com.gsm._8th.class4.backed.task._1._1.domain.service;

import com.gsm._8th.class4.backed.task._1._1.domain.dto.ArticleCreateRequestDto;
import com.gsm._8th.class4.backed.task._1._1.domain.dto.ArticleResponseDto;
import com.gsm._8th.class4.backed.task._1._1.domain.dto.ArticleUpdateRequestDto;
import com.gsm._8th.class4.backed.task._1._1.domain.entity.Article;
import com.gsm._8th.class4.backed.task._1._1.domain.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<ArticleResponseDto> getAllArticles() {
        return articleRepository.findAll()
                .stream()
                .map(ArticleResponseDto::from)
                .collect(Collectors.toList());
    }

    public  ArticleResponseDto getArticle(Long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NoSuchElementException("게시글을 찾을 수 없습니다."));
        return ArticleResponseDto.from(article);
    }

    @Transactional
    public ArticleResponseDto createArticle(ArticleCreateRequestDto dto) {
        Article article = Article.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
        return ArticleResponseDto.from(articleRepository.save(article));
    }

    @Transactional
    public ArticleResponseDto updateArticle(Long articleId, ArticleUpdateRequestDto dto) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow();
        article.update(
                dto.getTitle(),
                dto.getContent()
        );
        return ArticleResponseDto.from(article);
    }

    @Transactional
    public void deleteArticle(Long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NoSuchElementException("게시글을 찾을 수 없습니다."));
        articleRepository.delete(article);
    }


}
