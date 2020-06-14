package com.likai.blog.po;

import lombok.Data;

import java.util.Date;

@Data
public class Blog {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 学科类型
     */
    private String type;

    /**
     * 作者id
     */
    private String writerId;

    /**
     * 创建时间
     */
    private Date createTime;

}