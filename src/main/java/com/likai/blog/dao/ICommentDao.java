package com.likai.blog.dao;


import com.likai.blog.po.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ICommentDao {

    List<Comment> select(Comment comment);

    int deleteByKey(int key);
}