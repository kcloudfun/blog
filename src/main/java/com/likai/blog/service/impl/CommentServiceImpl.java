package com.likai.blog.service.impl;

import com.likai.blog.dao.ICommentDao;
import com.likai.blog.po.Comment;
import com.likai.blog.service.ICommentService;
import com.likai.common.constant.ObjectSourceEnum;
import com.likai.common.dao.ITemplateDao;
import com.likai.common.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired(required = false)
    private ITemplateDao templateDao;

    @Autowired(required = false)
    private ICommentDao commentDao;

    @Override
    public List<Comment> getByBlogId(int blogId) {
        Comment comment = new Comment();
        comment.setBlogId(blogId);
        return commentDao.select(comment);
    }

    @Override
    public List<Comment> getByCommentUser(int commentUser) {
        Comment comment = new Comment();
        comment.setCommentWriterId(commentUser);
        return commentDao.select(comment);
    }

    @Override
    public Boolean addComment(Comment comment) {
        int a = templateDao.oneInsert("t_comment", BeanUtils.bean2map(comment, ObjectSourceEnum.NORMAL.getValue()));
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean deleteByKey(Integer key) {
        int a = commentDao.deleteByKey(key);
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }
}
