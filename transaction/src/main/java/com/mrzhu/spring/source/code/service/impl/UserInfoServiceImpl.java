package com.mrzhu.spring.source.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mrzhu.spring.source.code.po.UserInfo;
import com.mrzhu.spring.source.code.service.UserInfoService;
import com.mrzhu.spring.source.code.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author mrzhu
* @description 针对表【user_info(用户基础信息表)】的数据库操作Service实现
* @createDate 2025-10-25 18:21:40
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




