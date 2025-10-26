package com.mrzhu.spring.source.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mrzhu.spring.source.code.dto.UserRegisterDTO;
import com.mrzhu.spring.source.code.exception.BusinessException;
import com.mrzhu.spring.source.code.exception.ErrorCode;
import com.mrzhu.spring.source.code.po.UserInfoPO;
import com.mrzhu.spring.source.code.service.UserInfoService;
import com.mrzhu.spring.source.code.mapper.UserInfoMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author mrzhu
 * @description 针对表【user_info(用户基础信息表)】的数据库操作Service实现
 * @createDate 2025-10-25 18:21:40
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfoPO>
    implements UserInfoService {
    
    
    private final UserInfoMapper userInfoMapper;
    
    public UserInfoServiceImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }
    
    @Transactional
    @Override
    public Boolean saveUserInfo(UserRegisterDTO userRegisterDTO) {
        // 属性拷贝和设置
        UserInfoPO userInfoPO = new UserInfoPO();
        BeanUtils.copyProperties(userRegisterDTO, userInfoPO);
        userInfoPO.setRegistry_time(new Date());
        
        int insert = userInfoMapper.insert(userInfoPO);
        if(userRegisterDTO.getNick_name().equals("user1")){
            // 如果没有注解@Transactional，就算抛出异常，插入的数据也不会回滚。
            // 也就是说mapper的增删改方法是会自己创建事务的。
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"注册的用户user1错误");
        }
        
        return insert > 0;
    }
}




