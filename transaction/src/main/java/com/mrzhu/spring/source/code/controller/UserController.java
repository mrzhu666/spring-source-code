package com.mrzhu.spring.source.code.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mrzhu.spring.source.code.common.BaseResponse;
import com.mrzhu.spring.source.code.common.ResultUtils;
import com.mrzhu.spring.source.code.dto.UserRegisterDTO;
import com.mrzhu.spring.source.code.exception.BusinessException;
import com.mrzhu.spring.source.code.exception.ErrorCode;
import com.mrzhu.spring.source.code.mapper.UserInfoMapper;
import com.mrzhu.spring.source.code.po.UserInfoPO;
import com.mrzhu.spring.source.code.service.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @Operation(summary = "用户注册")
    @PostMapping("/register")
    public BaseResponse<Boolean> register(@RequestBody UserRegisterDTO userRegisterDTO){
        Boolean result = userInfoService.saveUserInfo(userRegisterDTO);
        if(userRegisterDTO.getNick_name().equals("user1")){
            // 带事务的方法之外抛出异常，无法回滚。说明方法在准备返回前，事务就已提交。
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"注册的用户user1错误");
        }
        
        return ResultUtils.success(result);
    }
    
    
    
    @Operation(summary = "查询所有用户")
    @PostMapping("/selectListAll")
    public BaseResponse<List<UserInfoPO>> selectListAll(){
        LambdaQueryWrapper<UserInfoPO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(UserInfoPO::getUser_id, UserInfoPO::getReal_name, UserInfoPO::getNick_name);
        List<UserInfoPO> userInfos = userInfoMapper.selectList(queryWrapper);
        //log.info(userInfos.toString());
        return ResultUtils.success(userInfos);
    }
    
    @Operation(summary = "查询用户信息")
    @PostMapping("/select")
    public BaseResponse<UserInfoPO> selectById(Long id){
        UserInfoPO byId = userInfoService.getById(id);
        log.info(byId.toString());
        return ResultUtils.success(byId);
    }
    
}
