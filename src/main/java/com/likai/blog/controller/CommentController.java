package com.likai.blog.controller;

import com.likai.blog.po.Comment;
import com.likai.blog.service.ICommentService;
import com.likai.common.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/comment/v1")
@RestController
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @GetMapping("/get/{blogId}")
    public CommonResult<List<Comment>> getByBlogId(@PathVariable Integer blogId) {
        CommonResult<List<Comment>> result = new CommonResult<>();
        result.setData(commentService.getByBlogId(blogId));
        return result;
    }

    @GetMapping("/get/{commentUser}")
    public CommonResult<List<Comment>> getByCommentUser(@PathVariable Integer commentUser) {
        CommonResult<List<Comment>> result = new CommonResult<>();
        result.setData(commentService.getByCommentUser(commentUser));
        return result;
    }

    @PostMapping("/add")
    public CommonResult<Boolean> addComment(@RequestBody Comment comment) {
        CommonResult<Boolean> result = new CommonResult<>();
        result.setData(commentService.addComment(comment));
        return result;
    }

    @PostMapping("/delete/{id}")
    public CommonResult<Boolean> deleteByKey(@PathVariable Integer id) {
        CommonResult<Boolean> result = new CommonResult<>();
        result.setData(commentService.deleteByKey(id));
        return null;
    }
}
