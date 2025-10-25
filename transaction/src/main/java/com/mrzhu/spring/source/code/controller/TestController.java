package com.mrzhu.spring.source.code.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Tag(name = "测试用")
public class TestController {
    
    @Operation(summary = "测试接口")
    @Parameters({
        @Parameter(name = "test", description = "测试参数",required = true,in = ParameterIn.PATH)
    })
    @GetMapping("/test")
    public String test(@RequestParam(value = "test", defaultValue = "测试接口") String test){
        log.info("测试接口");
        return test;
    }
    
}
