package com.likai.blog.service.impl;

import com.likai.blog.dao.ITypeDao;
import com.likai.blog.po.Type;
import com.likai.blog.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements ITypeService {

    @Autowired(required = false)
    private ITypeDao typeDao;

    @Override
    public List<Type> getAll() {
        return typeDao.selectAll();
    }
}
