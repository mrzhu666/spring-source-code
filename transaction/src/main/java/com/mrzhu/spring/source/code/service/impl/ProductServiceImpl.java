package com.mrzhu.spring.source.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mrzhu.spring.source.code.po.Product;
import com.mrzhu.spring.source.code.service.ProductService;
import com.mrzhu.spring.source.code.mapper.ProductMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author mrzhu
* @description 针对表【product(产品表)】的数据库操作Service实现
* @createDate 2025-10-27 18:55:55
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{
    
    @Resource
    ProductMapper productMapper;
    
    @Override
    public void add() {
        Product product = productMapper.selectById(1L);
        product.setStock(product.getStock() + 5);
        productMapper.updateById(product);
    }
}




