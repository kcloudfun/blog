package com.likai.blog.controller;

import com.likai.blog.po.Type;
import com.likai.blog.service.ITypeService;
import com.likai.common.vo.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type/v1")
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @GetMapping("/get/all")
    public CommonResult<List<Type>> getAllType() {
        CommonResult<List<Type>> result = new CommonResult();
        result.setData(typeService.getAll());
        return result;
    }
}
