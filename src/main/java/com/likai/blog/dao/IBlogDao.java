package com.likai.blog.dao;


import com.likai.blog.po.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IBlogDao {

    List<Blog> select(Blog blog);

    int deleteByKey(int id);

    int insert(Blog blog);
}