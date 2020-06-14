package com.likai.blog.service;

import com.likai.blog.po.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> getByType(String type);

    List<Blog> getByUser(String writerId);

    boolean saveBlog(Blog blog);

    boolean deleteBlog(int key);
}
