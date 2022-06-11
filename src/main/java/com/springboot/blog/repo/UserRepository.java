package com.springboot.blog.repo;

import com.springboot.blog.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface UserRepository extends ElasticsearchRepository<User, String> {
    User findByUsername(String username);

}
