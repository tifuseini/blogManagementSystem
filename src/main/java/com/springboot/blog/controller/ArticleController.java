package com.springboot.blog.controller;

import com.springboot.blog.model.Article;
import com.springboot.blog.service.ArticleService;
import com.springboot.blog.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;
    private final UserService userService;

    public ArticleController(ArticleService articleService,UserService userService){
        this.articleService = articleService;
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model,
                        @AuthenticationPrincipal UserDetails userDetails,
                        @RequestParam(required = false, value = "q") String q,
                        @RequestParam(required = false, value = "page") Integer page,
                        @RequestParam(required = false, value = "size") Integer size) {
        if (q == null) {
            model.addAttribute("articles", articleService.getAll(getPageable(page, size)));
        } else {
            model.addAttribute("articles", articleService.search(q, getPageable(page, size)));
        }

        return "article/index";
    }

    @GetMapping("/show/{link}")
    public String getPost(@AuthenticationPrincipal UserDetails userDetails,
                          @PathVariable String link, Model model) {
        Optional<Article> article = articleService.getByLink(link);
        if (article.isPresent()) {
            model.addAttribute("article", article.get());
        } else {
            throwNotFoundException(link);
        }

        return "article/show";
    }




    private Pageable getPageable(Integer page, Integer size) {
        if (page == null || size == null) {
            return PageRequest.of(0, 20);
        }

        return PageRequest.of(page, size, new Sort(Sort.Direction.DESC, "createdDate"));
    }
}
