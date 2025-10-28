package com.mrzhu.spring.source.code.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;


/**
 * 登录用户上下文
 */
@UtilityClass
public class LoginUserContext {
    public static final String ATTACHMENT_LOGIN_USER = "loginUserId";
    private static final Long DEFAULT_SYSTEM_USER_ID = -1L;
    
    public static Long getLoginId() {
        String LoginId;
        // 如果session存储用户对象，会导致需要依赖会业务模块的实体
        try{
            //多线程调用那里会报错不知道为什么，提示对象被回收
            LoginId = (String) HttpServletContext.getSession().getAttribute(ATTACHMENT_LOGIN_USER);
        }catch (IllegalStateException e){
            return DEFAULT_SYSTEM_USER_ID;
        }
        
        //String LoginId = RpcContext.getServerAttachment().getAttachment(ATTACHMENT_LOGIN_USER);
        if (StringUtils.isBlank(LoginId) || !isLong(LoginId)) {
            return DEFAULT_SYSTEM_USER_ID;
        }
        return Long.valueOf(LoginId);
    }
    
    private static boolean isLong(String s) {
        if (StringUtils.isBlank(s)) {
            return false;
        } else {
            try {
                Long.parseLong(s);
                return true;
            } catch (NumberFormatException var2) {
                return false;
            }
        }
    }
    
}
