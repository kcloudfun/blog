package com.likai.blog.po;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 博客id
     */
    private Integer blogId;

    /**
     * 内容
     */
    private String content;

    /**
     * 评论人id
     */
    private Integer commentWriterId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 回复评论id
     */
    private Integer replyId;


}