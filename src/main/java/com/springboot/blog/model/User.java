package com.springboot.blog.model;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "USER",type = "user")
public class User {
}
