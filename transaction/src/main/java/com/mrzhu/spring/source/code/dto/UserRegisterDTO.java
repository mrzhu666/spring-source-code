package com.mrzhu.spring.source.code.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserRegisterDTO {
    
    @Schema(description = "昵称",example = "user1", requiredMode = Schema.RequiredMode.REQUIRED)
    String nick_name;
    
    @Schema(description = "手机号码，可以为空，但手机号码和邮箱不能同时为空",example = "13123456789")
    String mobile;
    
    @Schema(description = "邮箱，可以为空，但手机号码和邮箱不能同时为空",example = "12345678901@qq.com")
    String email;
    
    @Schema(description = "密码，8到20位数字、字母、特殊字符组合",example = "12345678aA!", requiredMode = Schema.RequiredMode.REQUIRED)
    String password;
    
}
