package com.likai.blog.dao;


import com.likai.blog.po.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ITypeDao {

    List<Type> selectAll();
}