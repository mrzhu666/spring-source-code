package com.mrzhu.spring.source.code.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 用户基础信息表
 * @TableName user_info
 */
@TableName(value ="user_info")
@Data
public class UserInfo {
    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long user_id;

    /**
     * 真实名称
     */
    @TableField(value = "real_name")
    private String real_name;

    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    private String nick_name;

    /**
     * 手机号码
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 加密盐
     */
    @TableField(value = "salt")
    private String salt;

    /**
     * 注册时间
     */
    @TableField(value = "registry_time")
    private Date registry_time;

    /**
     * 创建者
     */
    @TableField(value = "create_user")
    private Long create_user;

    /**
     * 更新者
     */
    @TableField(value = "update_user")
    private Long update_user;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date create_time;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date update_time;

    /**
     * 是否删除 | 0、未删除 1、已删除
     */
    @TableField(value = "is_deleted")
    private Integer is_deleted;

    /**
     * 版本号
     */
    @TableField(value = "version")
    private Integer version;
}