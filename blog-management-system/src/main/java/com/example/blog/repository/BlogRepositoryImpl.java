package com.example.blog.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.blog.entity.Blog;

@Repository
public class BlogRepositoryImpl implements BlogRepository{
    public List findAll() {
        BlogRepositoryImpl blogRepo = new BlogRepositoryImpl();
        Blog blog = new Blog();
        LocalDateTime deletedAt = blog.getDeletedAt();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Blog WHERE deletedAt IS NOT NULL ORDER BY id DESC";
        List<Blog> siawase = new ArrayList<>();
         try { 

        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
      
            while (rs.next()) {
                blog.setId(rs.getInt("id"));
                blog.setTitle(rs.getString("title"));
                blog.setContent(rs.getString("content"));
                blog.setDeletedAt(rs.getTimestamp("deletedAt").toLocalDateTime()); // LocalDateTimeに変換
                

                siawase.add(blog);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        for (Blog a : siawase) {
            System.out.println("ID: " + a.getId() + ", Title: " + a.getTitle());
        }
        
        return siawase;
        
    }
}
