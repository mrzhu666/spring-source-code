package com.mrzhu.spring.source.code.controller;

import com.mrzhu.spring.source.code.service.ProductService;
import com.mrzhu.spring.source.code.service.SellService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.concurrent.*;

@Slf4j
@Tag(name = "商城服务")
@RestController
public class MallController {
    
    private ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 30,
        0L, TimeUnit.MILLISECONDS,
        new LinkedBlockingQueue<Runnable>());
    
    @Resource
    private SellService sellService;
    
    @Resource
    private ProductService productService;
    
    @PostMapping("/add")
    @Operation(description = "添加商品")
    public void add() {
        productService.add();
    }
    
    @PostMapping("/sell")
    @Operation(description = "商品购买")
    public void sell() {
        sellService.sellProduct();
    }
    
    
    /**
     * 运行后，Orders订单数量总数，会超过原来的商品的库存数
     */
    @PostMapping("/seckill")
    @Operation(description = "商品购买，秒杀模拟并发")
    public void seckill() {
        
        // 用于复制请求上下文到其它线程，因为远程调用需要判断当前用户
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        
        int thread_num = 20;
        
        CountDownLatch countDownLatch = new CountDownLatch(thread_num);
        for (int i = 0; i < thread_num; i++) {
            new Thread(() -> {
                try {
                    RequestContextHolder.setRequestAttributes(attributes);
                    countDownLatch.await();
                    sellService.sellProduct();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
            countDownLatch.countDown();
        }
    }
    
}
