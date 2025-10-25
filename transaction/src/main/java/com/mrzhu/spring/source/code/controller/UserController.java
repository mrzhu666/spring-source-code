package com.mrzhu.spring.source.code.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mrzhu.spring.source.code.common.BaseResponse;
import com.mrzhu.spring.source.code.common.ResultUtils;
import com.mrzhu.spring.source.code.mapper.UserInfoMapper;
import com.mrzhu.spring.source.code.po.UserInfo;
import com.mrzhu.spring.source.code.service.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Tag(name = "用户服务")
@RestController
public class UserController {
    @Resource
    UserInfoMapper userInfoMapper;
    
    @Resource
    UserInfoService userInfoService;
    
    
    @Operation(summary = "查询所有用户")
    @PostMapping("/selectListAll")
    public BaseResponse<List<UserInfo>> selectListAll(){
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(UserInfo::getUser_id, UserInfo::getReal_name, UserInfo::getNick_name);
        List<UserInfo> userInfos = userInfoMapper.selectList(queryWrapper);
        //log.info(userInfos.toString());
        return ResultUtils.success(userInfos);
    }
    
    @Operation(summary = "查询用户信息")
    @PostMapping("/select")
    public BaseResponse<UserInfo> selectById(Long id){
        UserInfo byId = userInfoService.getById(id);
        log.info(byId.toString());
        return ResultUtils.success(byId);
    }
    
}
