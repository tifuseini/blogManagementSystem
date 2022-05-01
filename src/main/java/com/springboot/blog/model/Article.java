package com.springboot.blog.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "ARTICLE_DOCUMENT")
public class Article {
}
