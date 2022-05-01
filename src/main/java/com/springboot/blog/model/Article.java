package com.springboot.blog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "ARTICLE_DOCUMENT")
public class Article {

    @Id
    private String id;

    private String title;

    private String link;



}
