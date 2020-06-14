package com.likai.blog.service.impl;

import com.likai.blog.dao.IBlogDao;
import com.likai.blog.po.Blog;
import com.likai.blog.service.IBlogService;
import com.likai.common.constant.ObjectSourceEnum;
import com.likai.common.dao.ITemplateDao;
import com.likai.common.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired(required = false)
    private ITemplateDao templateDao;

    @Autowired(required = false)
    private IBlogDao blogDao;

    @Override
    public List<Blog> getByType(String type) {
        Blog blog = new Blog();
        blog.setType(type);
        return blogDao.select(blog);
    }

    @Override
    public List<Blog> getByUser(String writerId) {
        Blog blog = new Blog();
        blog.setWriterId(writerId);
        return blogDao.select(blog);
    }

    @Override
    public boolean saveBlog(Blog blog) {
        blog.setType("Java");
        blog.setWriterId("1111");
        blog.setCreateTime(new Date());
        int a = blogDao.insert(blog);
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteBlog(int key) {
        int a = blogDao.deleteByKey(key);
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }
}
