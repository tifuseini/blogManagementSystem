package com.springboot.blog.service;

import com.springboot.blog.model.Article;
import com.springboot.blog.repo.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public Article save(Article article){
        if(article.getId() == null){
            article.setId(UUID.randomUUID().toString());
        }
        return articleRepository.save(article);
    }

}
