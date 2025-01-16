package com.example.blog.repository;

import java.util.List;

import com.example.blog.entity.Blog;

public interface BlogRepository {
    Blog findById(int id);
    List<Blog> findAll();
    void save(Blog blog);
}
