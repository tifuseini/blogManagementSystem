package com.springboot.blog.controller;

import com.springboot.blog.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;
}
