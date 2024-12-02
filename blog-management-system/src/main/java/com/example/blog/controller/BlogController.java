package com.example.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.blog.entity.Blog;
import com.example.blog.service.BlogService;

@Controller
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public String listBlogs(Model model) {

        List<Blog> blogs = blogService.list();

        model.addAttribute("blogs", blogs);

        return "blog/list";
    }
}
