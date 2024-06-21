package com.test.board.dto;

import com.test.board.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {

    private Long id;

    private String title; //제목
    private String content; //내용

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
