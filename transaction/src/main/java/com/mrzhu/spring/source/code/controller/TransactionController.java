package com.mrzhu.spring.source.code.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@Tag(name = "事务")
public class TransactionController {
    
    
    @PostMapping("/selectList")
    public Integer transaction(){
        return null;
    }
}
