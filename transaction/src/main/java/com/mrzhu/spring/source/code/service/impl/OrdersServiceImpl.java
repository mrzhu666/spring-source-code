package com.mrzhu.spring.source.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mrzhu.spring.source.code.po.Orders;
import com.mrzhu.spring.source.code.service.OrdersService;
import com.mrzhu.spring.source.code.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author mrzhu
* @description 针对表【orders(订单表)】的数据库操作Service实现
* @createDate 2025-10-27 19:05:47
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{

}




