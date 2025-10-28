package com.mrzhu.spring.source.code.service;

import com.mrzhu.spring.source.code.po.Product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author mrzhu
* @description 针对表【product(产品表)】的数据库操作Service
* @createDate 2025-10-27 18:55:55
*/
public interface ProductService extends IService<Product> {

    void add();
}
