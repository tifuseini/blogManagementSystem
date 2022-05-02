package com.springboot.blog.util;

import com.springboot.blog.model.User;
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
    public Mono<UserDetails> findByUsername(String s) {
        User user = userRepository.findByUsername(s);
        if (user == null){
            return Mono.empty();
        }
        return Mono.just( new org.springframework.security.core.userdetails
                .User(user.getUsername(),user.getPassword()))

    }
}
