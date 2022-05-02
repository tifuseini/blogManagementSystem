package com.springboot.blog.controller;

import com.springboot.blog.service.UserService;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.webjars.NotFoundException;

@ControllerAdvice
public class BaseControllerAdvice {

    private final UserService userService;

    public BaseControllerAdvice(UserService userService){
        this.userService = userService;
    }

    @ExceptionHandler(NotFoundException.class)

}
