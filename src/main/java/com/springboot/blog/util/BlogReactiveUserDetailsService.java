package com.springboot.blog.util;

import com.springboot.blog.model.User;
import com.springboot.blog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Service
public class BlogReactiveUserDetailsService implements ReactiveUserDetailsService {

    @Autowired
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
                .User(user.getUsername(),user.getPassword(), Arrays.asList(new SimpleGrantedAuthority(user.getRole()))));
    }
}
