package com.example.blog.controller;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.blog.entity.Blog;
import com.example.blog.form.BlogForm;
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

    @GetMapping("/blogs/new")
    public String showBlogForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/form";
    }

    // 新規ブログ記事を保存する処理
    @PostMapping("/blogs")
    public String createBlog(@Valid @ModelAttribute BlogForm blogForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "blog/form";  // バリデーションエラーがあればフォームを再表示
        }

        Blog blog = new Blog();
        blog.setTitle(blogForm.getTitle());
        blog.setContent(blogForm.getContent());
        blog.setCreatedAt(LocalDateTime.now());  // 作成日時
        blog.setUpdatedAt(LocalDateTime.now());  // 更新日時
        blogService.save(blog);

        return "redirect:/blogs";  // 作成後にブログ一覧にリダイレクト
    }
    
    @GetMapping("/blogs/{id}")
    public String viewBlog(@PathVariable int id, Model model) {
        Blog blog = blogService.detail(id);
        if (blog == null) {
            return "error/404";  // ブログが見つからない場合のエラーページ
        }
        model.addAttribute("blog", blog);
        return "blog/detail";  // 詳細ページのテンプレート
    }
}
