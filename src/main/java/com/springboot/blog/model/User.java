package com.springboot.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "USER",type = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
}
