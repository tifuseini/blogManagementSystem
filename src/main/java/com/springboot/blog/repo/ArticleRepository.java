package com.springboot.blog.repo;

import com.springboot.blog.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface ArticleRepository extends ElasticsearchRepository<Article,String> {

    Optional<Article> findByLink(String link);
}
