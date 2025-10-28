package com.mrzhu.spring.source.code.service.impl;

import com.mrzhu.spring.source.code.exception.BusinessException;
import com.mrzhu.spring.source.code.exception.ErrorCode;
import com.mrzhu.spring.source.code.mapper.OrdersMapper;
import com.mrzhu.spring.source.code.mapper.ProductMapper;
import com.mrzhu.spring.source.code.po.Orders;
import com.mrzhu.spring.source.code.po.Product;
import com.mrzhu.spring.source.code.service.SellService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.locks.ReentrantLock;

@Service
public class SellServiceImpl implements SellService {
    
    @Resource
    ProductMapper productMapper;
    
    @Resource
    OrdersMapper ordersMapper;
    
    private ReentrantLock reentrantLock = new ReentrantLock(true);
    
    @Transactional
    @Override
    public void sellProduct() {
        try{
            reentrantLock.lock();
            Product product = productMapper.selectById(1L);
            if (product.getStock() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "商品已卖完");
            }
            //扣除库存
            product.setStock(product.getStock() - 1);
            productMapper.updateById(product);
            //创建订单
            Orders orders = new Orders();
            orders.setProductId(product.getProductId());
            orders.setQuantity(1);
            orders.setUserId(1L);
            ordersMapper.insert(orders);
        }finally {
            reentrantLock.unlock();
        }
    }
}
