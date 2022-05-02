package com.springboot.blog.controller;

import com.springboot.blog.service.UserService;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class BaseControllerAdvice {

    private final UserService userService;
}
