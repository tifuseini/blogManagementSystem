package com.springboot.blog.util;

import com.springboot.blog.repo.UserRepository;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BlogReactiveUserDetailsService implements ReactiveUserDetailsService {

    private final UserRepository userRepository;

    public BlogReactiveUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;

    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return null;
    }
}
