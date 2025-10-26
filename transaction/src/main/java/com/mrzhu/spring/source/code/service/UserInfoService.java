package com.mrzhu.spring.source.code.service;

import com.mrzhu.spring.source.code.dto.UserRegisterDTO;
import com.mrzhu.spring.source.code.po.UserInfoPO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author mrzhu
* @description 针对表【user_info(用户基础信息表)】的数据库操作Service
* @createDate 2025-10-25 18:21:40
*/
public interface UserInfoService extends IService<UserInfoPO> {

    Boolean saveUserInfo(UserRegisterDTO userInfo);
}
