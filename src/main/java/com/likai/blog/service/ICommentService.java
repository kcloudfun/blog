package com.likai.blog.service;

import com.likai.blog.po.Comment;

import java.util.List;

public interface ICommentService {

    List<Comment> getByBlogId(int blogId);

    List<Comment> getByCommentUser(int commentUser);

    Boolean addComment(Comment comment);

    Boolean deleteByKey(Integer key);
}
