package com.example.blog.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.blog.entity.Blog;

@Repository
public class BlogRepositoryImpl implements BlogRepository {

    @Autowired
    private DataSource dataSource;

    
    @Override
    public Blog findById(int id) {
        String sql = "SELECT * FROM blogs WHERE id = ? AND deleted_at IS NULL";
        Blog blog =null;
        
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

               ps.setInt(1, id);
               try (ResultSet rs = ps.executeQuery()) {
                   if (rs.next()) {
                       blog = new Blog();
                       blog.setId(rs.getInt("id"));
                       blog.setTitle(rs.getString("title"));
                       blog.setContent(rs.getString("content"));
                       blog.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                       blog.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
                       if (rs.getTimestamp("deleted_at") != null) {
                           blog.setDeletedAt(rs.getTimestamp("deleted_at").toLocalDateTime());
                       }
                   }
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }

           return blog;
       }

                
    
    @Override
    public List<Blog> findAll() {
        String sql = "SELECT * FROM blogs WHERE deleted_at IS NULL ORDER BY id DESC";
        List<Blog> blogs = new ArrayList<>();

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Blog blog = new Blog();
                blog.setId(rs.getInt("id"));
                blog.setTitle(rs.getString("title"));
                blog.setContent(rs.getString("content"));
                blog.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                blog.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
                if (rs.getTimestamp("deleted_at") != null) {
                    blog.setDeletedAt(rs.getTimestamp("deleted_at").toLocalDateTime());
                }

                blogs.add(blog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return blogs;
    }

    @Override
    public void save(Blog blog) {
        String sql = "INSERT INTO blogs (title, content, created_at, updated_at) VALUES (?, ?, ?, ?)";
        
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, blog.getTitle());
            ps.setString(2, blog.getContent());
            ps.setTimestamp(3, java.sql.Timestamp.valueOf(blog.getCreatedAt()));
            ps.setTimestamp(4, java.sql.Timestamp.valueOf(blog.getUpdatedAt()));

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
