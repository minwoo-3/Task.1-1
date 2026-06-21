package com.gsm._8th.class4.backed.task._1._1.domain.controller;

import com.gsm._8th.class4.backed.task._1._1.domain.dto.ArticleCreateRequestDto;
import com.gsm._8th.class4.backed.task._1._1.domain.dto.ArticleResponseDto;
import com.gsm._8th.class4.backed.task._1._1.domain.dto.ArticleUpdateRequestDto;
import com.gsm._8th.class4.backed.task._1._1.domain.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<ArticleResponseDto>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleResponseDto> getArticle(@PathVariable Long articleId) {
        return ResponseEntity.ok(articleService.getArticle(articleId));
    }

    @PostMapping
    public ResponseEntity<ArticleResponseDto> createArticle(@RequestBody ArticleCreateRequestDto dto) {
        return ResponseEntity.status(201).body(articleService.createArticle(dto));
    }

    @PatchMapping("/{articleId}")
    public ResponseEntity<ArticleResponseDto> updateArticle(
            @PathVariable Long articleId,
            @RequestBody ArticleUpdateRequestDto dto) {
        return ResponseEntity.ok(articleService.updateArticle(articleId,dto));
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long articleId) {
        articleService.deleteArticle(articleId);
        return ResponseEntity.noContent().build();
    }
}
