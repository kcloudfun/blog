package com.likai.blog.controller;

import com.likai.blog.po.Blog;
import com.likai.blog.service.IBlogService;
import com.likai.common.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/v1")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/param/type")
    public CommonResult<List<Blog>> getByType(String type) {
        CommonResult<List<Blog>> result = new CommonResult<>();
        result.setData(blogService.getByType(type));
        return result;
    }

    @GetMapping("/param/writerId")
    public CommonResult<List<Blog>> getByUser(String writerId) {
        CommonResult<List<Blog>> result = new CommonResult<>();
        result.setData(blogService.getByUser(writerId));
        return result;
    }

    @PostMapping("/add")
    public CommonResult<Boolean> addBlog(@RequestBody Blog blog) {
        CommonResult<Boolean> result = new CommonResult<>();
        result.setData(blogService.saveBlog(blog));
        return result;
    }

    @PostMapping("/delete/{id}")
    public CommonResult<Boolean> deleteBlog(@PathVariable Integer id) {
        CommonResult<Boolean> result = new CommonResult<>();
        result.setData(blogService.deleteBlog(id));
        return result;
    }
}
